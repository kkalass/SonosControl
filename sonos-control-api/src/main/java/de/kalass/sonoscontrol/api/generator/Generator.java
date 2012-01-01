package de.kalass.sonoscontrol.api.generator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.common.base.Preconditions;
import com.google.common.io.Files;

import de.kalass.sonoscontrol.api.generator.SCDPType.ActionOutputType;
import de.kalass.sonoscontrol.api.generator.SCDPType.ActionType;
import de.kalass.sonoscontrol.api.generator.SCDPType.CompoundActionOutputType;
import de.kalass.sonoscontrol.api.generator.SCDPType.StateVariableType;


public class Generator {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		final File docDir = new File(args.length == 0 ? "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/sonos-control-api/doc/sonos/example-device-descriptions" : args[0]);
		final File outputDir = new File(args.length < 2 ? "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/sonos-control-api/target/gen-src/sonos-api/" : args[1]);
		Preconditions.checkArgument(docDir.isDirectory());
		
		for (final File f : docDir.listFiles()) {
			if (!f.getName().endsWith(".xml")) {
				continue;
			}
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.parse(f);
			final String name = getName(f);
			final String serviceName = name + "Service";
			final String fqPackageName = "de.kalass.sonoscontrol.api." + name.toLowerCase();
			final SCDP scdp = SCDPReader.read(document);
			if (scdp != null) {
				System.out.println("----------------------------");
				System.out.println(f.getName() + ": ");
				System.out.println("----------------------------");
				
				final SCDPType type = new SCDPType(scdp, fqPackageName, serviceName);
				for (StateVariableType stateVariable : type.getStateVariables()) {
					final File typeFile = stateVariable.getJavaFile(outputDir);
					Files.createParentDirs(typeFile);
					final String sourceCode = stateVariable.generateSourceCode();
					Files.write(sourceCode, typeFile, UTF8);
					System.out.println(sourceCode);
					System.out.println("");
				}
				
				for (ActionType action : type.getActions()) {
					final ActionOutputType out = action.getOut();
					if (out instanceof CompoundActionOutputType) {
						final CompoundActionOutputType compound = (CompoundActionOutputType)out;
						final File typeFile = compound.getJavaFile(outputDir);
						Files.createParentDirs(typeFile);
						final String sourceCode = compound.generateSourceCode();
						Files.write(sourceCode, typeFile, UTF8);
						System.out.println(sourceCode);
						System.out.println("");
					}
				}
				final File serviceFile = type.getServiceInterfaceJavaFile(outputDir);
				Files.createParentDirs(serviceFile);
				final String serviceFileSourceCode = type.generateServiceInterfaceSourceCode();
				Files.write(serviceFileSourceCode, serviceFile, UTF8);
				
				System.out.println(serviceFileSourceCode);
				System.out.println("");
			}
		}
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
