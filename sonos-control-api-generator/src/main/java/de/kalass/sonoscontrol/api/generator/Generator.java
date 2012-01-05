package de.kalass.sonoscontrol.api.generator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

import de.kalass.sonoscontrol.api.generator.SCDPType.ActionOutputType;
import de.kalass.sonoscontrol.api.generator.SCDPType.ActionType;
import de.kalass.sonoscontrol.api.generator.SCDPType.CompoundActionOutputType;
import de.kalass.sonoscontrol.api.generator.SCDPType.NameFactory;
import de.kalass.sonoscontrol.api.generator.SCDPType.ServiceNameFactory;
import de.kalass.sonoscontrol.api.generator.SCDPType.StateVariableType;


public class Generator {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	public static final class TypeNameMappings {
		private final Map<String, JavaClassName> _generalMappings = Maps.newHashMap();
		private final Map<String, Map<String, JavaClassName>> _serviceMappings = Maps.newHashMap();
		private boolean _serviceStage;
		public void add(String typename, JavaClassName clsname) {
			if (_serviceStage) {
				throw new IllegalStateException("first finish all general type mappings, before doing service-specific ones");
			}
			_generalMappings.put(typename, clsname);
		}
		public void add(String serviceName, String typename, JavaClassName clsname) {
			_serviceStage = true;
			Map<String, JavaClassName> map = _serviceMappings.get(serviceName);
			if (map == null) {
				map = Maps.newHashMap();
				map.putAll(_generalMappings);
				_serviceMappings.put(serviceName, map);
			}
			map.put(typename, clsname);
		}
		public Function<String, Function<String, JavaClassName>> asFkt() {
			Map<String, Function<String, JavaClassName>> m = Maps.transformValues(_serviceMappings, new Function<Map<String, JavaClassName>, Function<String, JavaClassName>>() {
				@Override
				public Function<String, JavaClassName> apply(
						Map<String, JavaClassName> input) {
					return Functions.forMap(input, null);
				}
			});
			return Functions.forMap(m, Functions.forMap(_generalMappings, null));
		}
		
	}
	public static final class ServiceNameFactoryImpl implements ServiceNameFactory {
		private final JavaPackageName _servicePackageName;
		private final String _serviceName;
		private final JavaPackageName _modelPackageName;
		private final Map<String, Collection<String>> _servicesByTypeName;
		private final Function<String, JavaClassName> _mapping;
		
		private ServiceNameFactoryImpl(
				JavaPackageName servicePackageName,
				String serviceName,
				JavaPackageName modelbasePackageName,
				Function<String, JavaClassName> mapping,
				Map<String, Collection<String>> servicesByTypeName
		) {
			_serviceName = serviceName;
			_mapping = Preconditions.checkNotNull(mapping);
			_servicePackageName = servicePackageName;
			_modelPackageName = modelbasePackageName.childPackage(serviceName.toLowerCase());
			_servicesByTypeName = servicesByTypeName;
		}
		@Override
		public JavaClassName getServiceClassName() {
			return _servicePackageName.childClass(_serviceName + "Service");
		}
		@Override
		public JavaClassName getModelClassName(String name) {
			final JavaClassName javaClassName = _mapping.apply(name);
			Collection<String> names = _servicesByTypeName.get(name);
			if (names == null) {
				names = new HashSet<String>();
				_servicesByTypeName.put(name, names);
			}
			names.add(_serviceName);
			return javaClassName == null ? _modelPackageName.childClass(name) : javaClassName;
		}
	}
	
	public static final class NameFactoryImpl implements NameFactory {
		private final JavaPackageName _corePackageName;
		private final JavaPackageName _servicePackageName;
		private final JavaPackageName _modelBasePackageName;
		private final Function<String, Function<String, JavaClassName>> _mapping;
		private final Map<String, Collection<String>> _servicesByTypeName;
		
 		public NameFactoryImpl(JavaPackageName corePackageName,
				JavaPackageName servicePackageName,
				JavaPackageName modelBasePackageName,
				Function<String, Function<String, JavaClassName>> mapping
 		) {
			super();
			_corePackageName = corePackageName;
			_servicePackageName = servicePackageName;
			_modelBasePackageName = modelBasePackageName;
			_mapping = Preconditions.checkNotNull(mapping);
			_servicesByTypeName = Maps.newHashMap();
		}

		@Override
		public JavaPackageName getCorePackageName() {
			return _corePackageName;
		}
		
		@Override
		public ServiceNameFactory getServiceNameFactory(String serviceName) {
			return new ServiceNameFactoryImpl(
					_servicePackageName, serviceName, _modelBasePackageName,
					_mapping.apply(serviceName),
					_servicesByTypeName
		    );
		}

		public Map<String, Collection<String>> getServicesByTypeName() {
			return _servicesByTypeName;
		}
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		final File docDir = new File(args.length == 0 ? "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/sonos-control-api-generator/doc/sonos/example-device-descriptions" : args[0]);
		final File outputDir = new File(args.length < 2 ? "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/sonos-control-api/src/main/java/" : args[1]);
		final File templateInputDir = new File(args.length < 3 ? "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/sonos-control-api-generator/src/main/java/" : args[2]);
		Preconditions.checkArgument(docDir.isDirectory());

		final JavaPackageName fqPackageName = JavaPackageName.valueOf("de.kalass.sonoscontrol.api");
		final JavaPackageName corePackageName = fqPackageName.childPackage("core");
		final JavaPackageName servicesPackageName = fqPackageName.childPackage("services");
		final JavaPackageName modelPackageName = fqPackageName.childPackage("model");
		
		// make sure to start from a clean state
		delete(corePackageName.asFile(outputDir));
		delete(servicesPackageName.asFile(outputDir));
		delete(modelPackageName.asFile(outputDir));
		
		// copy all files that will not be generated
		copyFromTo(corePackageName, templateInputDir, outputDir);
		copyFromTo(servicesPackageName, templateInputDir, outputDir);
		copyFromTo(modelPackageName, templateInputDir, outputDir);
		
		final List<SCDP> types = readTypeDescriptions(docDir);
		
		final TypeNameMappings mappings = new TypeNameMappings();
		mappings.add("MemberID", modelPackageName.childClass("MemberID"));
		
		final NameFactoryImpl nameFactory = new NameFactoryImpl(corePackageName, servicesPackageName, modelPackageName, mappings.asFkt());
		
		for (SCDP scdp : types) {
			System.out.println("----------------------------");
			System.out.println(scdp.getName() + ": ");
			System.out.println("----------------------------");
			
			final SCDPType type = new SCDPType(scdp, nameFactory);
			for (StateVariableType stateVariable : type.getStateVariables()) {
				final File typeFile = stateVariable.getJavaClassName().asFile(outputDir);
				if (!typeFile.exists()) {

					Files.createParentDirs(typeFile);
					final String sourceCode = stateVariable.generateSourceCode();
					Files.write(sourceCode, typeFile, UTF8);
					//System.out.println(sourceCode);
					System.out.println("StateVariableType: " + typeFile);
				}
			}

			for (ActionType action : type.getActions()) {
				final ActionOutputType out = action.getOut();
				if (out instanceof CompoundActionOutputType) {
					final CompoundActionOutputType compound = (CompoundActionOutputType)out;
					final File typeFile = compound.getJavaClassName().asFile(outputDir);
					if (!typeFile.exists()) {
						Files.createParentDirs(typeFile);
						final String sourceCode = compound.generateSourceCode();
						Files.write(sourceCode, typeFile, UTF8);
						//System.out.println(sourceCode);
						System.out.println("ActionOutputType: " + typeFile);
					}
				}
			}
			final File serviceFile = type.getServiceName().asFile(outputDir);
			if (!serviceFile.exists()) {
				Files.createParentDirs(serviceFile);
				final String serviceFileSourceCode = type.generateServiceInterfaceSourceCode();
				Files.write(serviceFileSourceCode, serviceFile, UTF8);
				System.out.println(serviceFileSourceCode);
				System.out.println("");
			}	
		}
		
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
	private static List<SCDP> readTypeDescriptions(final File docDir) throws ParserConfigurationException, SAXException, IOException {
		final List<SCDP> types = new ArrayList<SCDP>();
		for (final File f : docDir.listFiles()) {
			if (!f.getName().endsWith(".xml")) {
				continue;
			}
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.parse(f);
			final String name = getName(f);
			
			final SCDP scdp = SCDPReader.read(name, document);
			if (scdp != null) {
				
				types.add(scdp);
			}
		}
		return types;
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
	
	private static String getName(final File f) {
		String base =  f.getName().substring(0, f.getName().length() - ".xml".length());
		if (base.endsWith("1")) {
			base = base.substring(0, base.length() - 1);
		} 
		if (base.equals("device_description")) {
			base = "DeviceDescription";
		}
		return base;
	}
}
