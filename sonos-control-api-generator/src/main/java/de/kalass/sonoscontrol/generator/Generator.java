package de.kalass.sonoscontrol.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Collection;
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
import com.google.common.io.Files;

import de.kalass.sonoscontrol.generator.model.JavaPackageName;
import de.kalass.sonoscontrol.generator.model.Service;
import de.kalass.sonoscontrol.generator.model.ServiceImpl;
import de.kalass.sonoscontrol.generator.model.StateVariable;
import de.kalass.sonoscontrol.generator.model.action.Action;
import de.kalass.sonoscontrol.generator.model.action.ActionOutput;
import de.kalass.sonoscontrol.generator.model.action.ActionOutputCompound;
import de.kalass.sonoscontrol.generator.model.types.BooleanType;
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
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        final String base= "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/";
        final File docDir = new File(args.length == 0 ? base+"sonos-control-api-generator/doc/sonos/example-device-descriptions" : args[0]);
        final File outputDir = new File(args.length < 2 ? base+"sonos-control-api/src/main/java/" : args[1]);
        final File templatesInputDir = new File(args.length < 3 ? base+"sonos-control-api-generator/src/main/ftl/" : args[2]);
        final File javaFilesInputDir = new File(args.length < 4 ? base+"sonos-control-api-generator/src/main/java/" : args[3]);
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

        // make sure to start from a clean state
        delete(corePackageName.asFile(outputDir));
        delete(servicesPackageName.asFile(outputDir));
        delete(modelPackageName.asFile(outputDir));
        delete(clingimplServicesPackageName.asFile(clingImplOutputDir));

        // copy all files that will not be generated
        copyFromTo(corePackageName, javaFilesInputDir, outputDir);
        copyFromTo(servicesPackageName, javaFilesInputDir, outputDir);
        copyFromTo(modelPackageName, javaFilesInputDir, outputDir);
        copyFromTo(clingimplServicesPackageName, javaFilesInputDir, clingImplOutputDir);

        final List<UpnpService> types = UpnpServiceReader.readTypeDescriptions(docDir);

        final TypeNameMappings mappings = new TypeNameMappings();
        mappings.add("MemberID", modelPackageName.childClass("MemberID"));
        mappings.add("InstanceID", modelPackageName.childClass("InstanceID"));

        final NameFactoryImpl nameFactory = new NameFactoryImpl(corePackageName, servicesPackageName, modelPackageName, mappings.asFkt());

        System.out.println("Generating API...");
        for (UpnpService scdp : types) {
            final Service type = new Service(scdp, nameFactory);
            for (StateVariable stateVariable : type.getStateVariables()) {
                final Type stateVariableType = stateVariable.getType();
                final File typeFile = stateVariableType.getJavaClassName().asFile(outputDir);
                if (!typeFile.exists() && stateVariableType instanceof CustomType) {

                    Files.createParentDirs(typeFile);
                    final String template;
                    if (stateVariableType instanceof BooleanType) {
                        template = "BooleanStateVariableType.ftl";
                    } else if (stateVariableType instanceof EnumType) {
                        template = "EnumStateVariableType.ftl";
                    } else {
                        template = "StateVariableType.ftl";
                    }
                    final String sourceCode = render(cfg, template, stateVariableType);
                    Files.write(sourceCode, typeFile, UTF8);
                    System.out.println("StateVariableType: " + typeFile);
                }
            }

            for (Action action : type.getActions()) {
                final ActionOutput out = action.getOut();
                if (out instanceof ActionOutputCompound) {
                    final ActionOutputCompound compound = (ActionOutputCompound)out;
                    final File typeFile = compound.getJavaClassName().asFile(outputDir);
                    if (!typeFile.exists()) {
                        Files.createParentDirs(typeFile);
                        final String sourceCode = render(cfg, "CompoundActionOutputType.ftl", compound);
                        Files.write(sourceCode, typeFile, UTF8);
                        System.out.println("ActionOutputType: " + typeFile);
                    }
                }
            }
            final File serviceFile = type.getJavaClassName().asFile(outputDir);
            if (!serviceFile.exists()) {
                Files.createParentDirs(serviceFile);
                final String sourceCode = render(cfg, "ServiceInterface.ftl", type);
                Files.write(sourceCode, serviceFile, UTF8);
                System.out.println("Service: " + scdp.getName());
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("Generating Cling Implementation");
        for (UpnpService scdp : types) {
            final ServiceImpl type = new ServiceImpl(scdp, nameFactory, clingimplServicesPackageName);
            final File serviceFile = type.getJavaImplClassName().asFile(clingImplOutputDir);
            if (!serviceFile.exists()) {
                Files.createParentDirs(serviceFile);
                final String sourceCode = render(cfg, "ServiceClingImpl.ftl", type);
                Files.write(sourceCode, serviceFile, UTF8);
                System.out.println("ServiceImpl: " + scdp.getName());
                System.out.println("");
            }
        }

        System.out.println("");
        Map<String, Collection<String>> candidatesForCommon = Maps.filterValues(nameFactory.getServicesByTypeName(), new Predicate<Collection<String>>() {
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
