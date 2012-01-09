package de.kalass.sonoscontrol.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import de.kalass.sonoscontrol.generator.model.IService;
import de.kalass.sonoscontrol.generator.model.JavaPackageName;
import de.kalass.sonoscontrol.generator.model.Service;
import de.kalass.sonoscontrol.generator.model.ServiceImpl;
import de.kalass.sonoscontrol.generator.model.StateVariable;
import de.kalass.sonoscontrol.generator.model.TypeFactoryImpl;
import de.kalass.sonoscontrol.generator.model.action.Action;
import de.kalass.sonoscontrol.generator.model.action.ActionOutput;
import de.kalass.sonoscontrol.generator.model.action.ActionOutputCompound;
import de.kalass.sonoscontrol.generator.model.types.BooleanType;
import de.kalass.sonoscontrol.generator.model.types.CompoundType;
import de.kalass.sonoscontrol.generator.model.types.CustomType;
import de.kalass.sonoscontrol.generator.model.types.EnumType;
import de.kalass.sonoscontrol.generator.model.types.Type;
import de.kalass.sonoscontrol.generator.upnp.UpnpService;
import de.kalass.sonoscontrol.generator.upnp.UpnpServiceReader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class Generator {
    /*
     * The tests need to be adjusted by hand, do not generally generate them
     */
    private static final boolean GENERATE_TESTS = false;
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        final String base= "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/";
        final File docDir = new File(args.length == 0 ? base+"sonos-control-api-generator/doc/sonos/example-device-descriptions" : args[0]);
        final File outputDir = new File(args.length < 2 ? base+"sonos-control-api/src/main/java/" : args[1]);
        final File testsOutputDir = new File(base+"sonos-control-api-clingimpl/src/test/java/");
        final File templatesInputDir = new File(args.length < 3 ? base+"sonos-control-api-generator/src/main/ftl/" : args[2]);
        final File javaFilesInputDir = new File(args.length < 4 ? base+"sonos-control-api-generator/src/main/java/" : args[3]);
        final File clingTestFilesInputDir = new File(base+"sonos-control-api-generator/src/test/java/");
        final File clingImplOutputDir = new File(args.length < 5 ? base+"sonos-control-api-clingimpl/src/main/java/" : args[4]);
        Preconditions.checkArgument(docDir.isDirectory());

        final Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(templatesInputDir);
        cfg.setObjectWrapper(new DefaultObjectWrapper());

        final JavaPackageName apiPackageName = JavaPackageName.valueOf("de.kalass.sonoscontrol.api");
        final JavaPackageName clingimplServicesPackageName = JavaPackageName.valueOf("de.kalass.sonoscontrol.clingimpl.services");
        final JavaPackageName corePackageName = apiPackageName.childPackage("core");
        final JavaPackageName servicesPackageName = apiPackageName.childPackage("services");
        final JavaPackageName modelPackageName = apiPackageName.childPackage("model");
        final JavaPackageName customEventModelPackage = JavaPackageName.valueOf("de.kalass.sonoscontrol.api.eventmodels");

        // make sure to start from a clean state
        delete(corePackageName.asFile(outputDir));
        delete(servicesPackageName.asFile(outputDir));
        delete(modelPackageName.asFile(outputDir));
        delete(clingimplServicesPackageName.asFile(clingImplOutputDir));
        if (GENERATE_TESTS) {
            delete(clingimplServicesPackageName.asFile(testsOutputDir));
        }

        // copy all files that will not be generated
        copyFromTo(corePackageName, javaFilesInputDir, outputDir);
        copyFromTo(servicesPackageName, javaFilesInputDir, outputDir);
        copyFromTo(modelPackageName, javaFilesInputDir, outputDir);
        copyFromTo(clingimplServicesPackageName, javaFilesInputDir, clingImplOutputDir);
        if (GENERATE_TESTS) {
            copyFromTo(clingimplServicesPackageName, clingTestFilesInputDir, testsOutputDir);
        }

        final List<UpnpService> types = UpnpServiceReader.readTypeDescriptions(docDir);

        final TypeConfigurations.Builder configBuilder = TypeConfigurations.builder();
        configBuilder.add("MemberID", modelPackageName.childClass("MemberID"));
        configBuilder.add("InstanceID", modelPackageName.childClass("InstanceID"));
        configBuilder.add("ZoneGroupTopology", "ThirdPartyMediaServers", customEventModelPackage.childPackage("zonegrouptopology").childClass("ThirdPartyMediaServers"));
        configBuilder.add("ZoneGroupTopology", "AvailableSoftwareUpdate", customEventModelPackage.childPackage("zonegrouptopology").childClass("AvailableSoftwareUpdate"));
        configBuilder.add("ZoneGroupTopology", "UpdateItem", customEventModelPackage.childPackage("zonegrouptopology").childClass("UpdateItem"));
        configBuilder.add("ZoneGroupTopology", "ZoneGroupState", customEventModelPackage.childPackage("zonegrouptopology").childClass("ZoneGroupState"));
        configBuilder.add("AVTransport", "LastChange", customEventModelPackage.childPackage("avtransport").childClass("LastAVTransportChange"));
        configBuilder.add("RenderingControl", "LastChange", customEventModelPackage.childPackage("renderingcontrol").childClass("LastRenderingControlChange"));

        final TypeConfigurations configurations = configBuilder.build();

        final NameFactoryImpl nameFactory = new NameFactoryImpl(corePackageName, servicesPackageName, modelPackageName, configurations);

        System.out.println("Generating API...");
        final List<IService> serviceTypes = new ArrayList<IService>();
        for (UpnpService scdp : types) {
            final IService type = new Service(scdp, nameFactory, new TypeFactoryImpl(configurations));
            serviceTypes.add(type);
            for (StateVariable stateVariable : type.getStateVariables()) {
                final Type stateVariableType = stateVariable.getType();
                final File typeFile = stateVariableType.getJavaClassName().asFile(outputDir);
                if (stateVariableType instanceof CustomType) {
                    final String template;
                    if (stateVariableType instanceof BooleanType) {
                        template = "BooleanStateVariableType.ftl";
                    } else if (stateVariableType instanceof EnumType) {
                        template = "EnumStateVariableType.ftl";
                    } else if (stateVariableType instanceof CompoundType) {
                        template = "CompoundType.ftl";
                    } else {
                        template = "StateVariableType.ftl";
                    }
                    autogenerate(cfg, template, stateVariableType, typeFile);
                }
            }

            for (Action action : type.getActions()) {
                final ActionOutput out = action.getOut();
                if (out instanceof ActionOutputCompound) {
                    final ActionOutputCompound compound = (ActionOutputCompound)out;
                    final CompoundType compoundType = (CompoundType)compound.getType();
                    final File typeFile = compoundType.getJavaClassName().asFile(outputDir);
                    autogenerate(cfg, "CompoundType.ftl", compoundType, typeFile);
                }
            }
            final File serviceFile = type.getJavaClassName().asFile(outputDir);
            autogenerate(cfg, "ServiceInterface.ftl", type, serviceFile);
        }

        System.out.println("");
        System.out.println("Generating Cling Implementation");
        for (IService service : serviceTypes) {
            final ServiceImpl type = new ServiceImpl(service, clingimplServicesPackageName);
            final File serviceFile = type.getJavaImplClassName().asFile(clingImplOutputDir);
            autogenerate(cfg, "ServiceClingImpl.ftl", type, serviceFile);

            if (GENERATE_TESTS) {
                final File serviceTestFile = type.getJavaImplClassName().getPackage()
                        .childClass(type.getJavaClassName().getName() + "Test").asFile(testsOutputDir);
                autogenerate(cfg, "ServiceClingImplTest.ftl", type, serviceTestFile);
            }
        }

        System.out.println("");
        final Map<String, Collection<String>> candidatesForCommon = Maps.filterValues(nameFactory.getServicesByTypeName(), new Predicate<Collection<String>>() {
            @Override
            public boolean apply(Collection<String> input) {
                return input.size() > 1;
            }
        });

        System.out.println("Candidates for common implementations: \n\t" + Joiner.on("\n\t").join(Iterables.transform(candidatesForCommon.entrySet(), new Function<Map.Entry<String, Collection<String>>, String> () {
            @Override
            public String apply(Entry<String, Collection<String>> input) {
                return Strings.padEnd(input.getKey() + ":", 25, ' ') +input.getValue();
            }
        })));
    }

    private static HashCode calculateHash(String sourceCode) {
        BufferedReader sr = new BufferedReader(new StringReader(sourceCode));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = sr.readLine()) != null) {
                // skip all autogenerated lines, but also empty lines and the import lines,
                // to allow for "organize imports" to be executed for generated files
                if (!line.startsWith("// AUTOGENERATED:") && !line.startsWith("import ") && !line.trim().isEmpty()) {
                    sb.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Hashing.md5().hashBytes(sourceCode.getBytes(UTF8));
    }
    private static void autogenerate(
            final Configuration cfg,
            final String templateName,
            final Object model,
            final File typeFile)
                    throws IOException {
        if (!typeFile.exists()) {
            Files.createParentDirs(typeFile);
            final String sourceCode = render(cfg, templateName, model);
            final HashCode hashCode = calculateHash(sourceCode);
            final String completeSourceCode =
                    "// AUTOGENERATED: " + hashCode.toString() + "\n" +
                            "// AUTOGENERATED: " + DateFormat.getDateTimeInstance().format(new Date()) + "\n" +
                            "// AUTOGENERATED: Please feel free to enhance this sourcecode manually \n" +
                            "// AUTOGENERATED: (for example by adding more structure or convenience methods), and\n" +
                            "// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden\n" +
                            sourceCode;
            Files.write(completeSourceCode, typeFile, UTF8);
            System.out.println(templateName + ": " + typeFile);
        }
    }

    private static void copyFromTo(JavaPackageName packageName, File input, File output) {
        File fromDir = packageName.asFile(input);
        File toDir = packageName.asFile(output);
        if (fromDir.exists()) {
            try {
                copyFromTo(fromDir, toDir);
            } catch (IOException e) {
                throw new IllegalStateException("Could not copy", e);
            }
        }
    }
    private static void copyFromTo(File input, File output) throws IOException {
        if (input.isDirectory()) {
            for (File f : input.listFiles()) {
                copyFromTo(f, new File(output, f.getName()));
            }
        } else {
            Files.createParentDirs(output);
            Files.copy(input, output);
        }
    }
    private static void delete(final File dir) {
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                delete(f);
            }
        }
        dir.delete();
    }


    private static final String render(Configuration cfg, String templateName, Object data) {

        StringWriter out = new StringWriter();
        try {
            Template temp = cfg.getTemplate(templateName);
            temp.process(ImmutableMap.<Object, Object>of("data", data), out);
        } catch (TemplateException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        out.flush();
        return out.toString();
    }
}
