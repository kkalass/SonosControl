package de.kalass.sonoscontrol.generator.upnp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;


public final class UpnpServiceReader {

    private UpnpServiceReader() {
        // utility constructor
    }
    @CheckForNull
    private static UpnpService parseServiceDocument(String sname, Document document) {
        Node root = document.getChildNodes().item(0);
        if (!"scpd".equals(root.getNodeName())) {
            return null;
        }

        final NodeList childNodes = root.getChildNodes();
        final int length = childNodes.getLength();
        final Map<String, UpnpStateVariable> vars = Maps.newHashMap();
        for (int i = 0; i< length; i++) {
            final Node item = childNodes.item(i);
            if ("serviceStateTable".equals(item.getNodeName())) {
                final NodeList serviceStateTable = item.getChildNodes();
                for (int i2 = 0; i2 < serviceStateTable.getLength(); i2++) {
                    Node stateVariable = serviceStateTable.item(i2);
                    if ("stateVariable".equals(stateVariable.getNodeName())) {
                        String name = null;
                        String dataType = null;
                        List<String> allowedValueList = new ArrayList<String>();
                        UpnpAllowedValueRange allowedValueRange = null;
                        NodeList svChildren = stateVariable.getChildNodes();
                        for (int i3 = 0; i3 < svChildren.getLength(); i3++) {
                            Node svChild = svChildren.item(i3);
                            String nodeName = svChild.getNodeName();
                            // TODO: support allowedValueRange
                            if ("name".equals(nodeName)) {
                                name = svChild.getTextContent();
                            } else if ("dataType".equals(nodeName)) {
                                dataType = svChild.getTextContent();
                            } else if ("allowedValueList".equals(nodeName)) {
                                NodeList allowedValueNodes = svChild.getChildNodes();
                                for (int i4 = 0; i4 < allowedValueNodes.getLength(); i4 ++) {
                                    Node allowedValueNode = allowedValueNodes.item(i4);
                                    if ("allowedValue".equals(allowedValueNode.getNodeName())) {
                                        allowedValueList.add(allowedValueNode.getTextContent());
                                    }
                                }
                            } else if ("allowedValueRange".equals(nodeName)) {
                                NodeList allowedValueRangeNodes = svChild.getChildNodes();
                                String minimum = null;
                                String maximum = null;
                                String step = null;
                                for (int i4 = 0; i4 < allowedValueRangeNodes.getLength(); i4 ++) {
                                    Node allowedValueRangeNode = allowedValueRangeNodes.item(i4);
                                    String allowedValueRangeNodeName = allowedValueRangeNode.getNodeName();
                                    if ("minimum".equals(allowedValueRangeNodeName)) {
                                        minimum = allowedValueRangeNode.getTextContent();
                                    } else if ("maximum".equals(allowedValueRangeNodeName)) {
                                        maximum = allowedValueRangeNode.getTextContent();
                                    } else if ("step".equals(allowedValueRangeNodeName)) {
                                        step = allowedValueRangeNode.getTextContent();
                                    }
                                }
                                Preconditions.checkNotNull(minimum);
                                Preconditions.checkNotNull(maximum);
                                allowedValueRange = new UpnpAllowedValueRange(minimum, maximum, step);
                            }

                        }
                        Preconditions.checkNotNull(name);
                        Preconditions.checkNotNull(dataType);
                        boolean sendsEvents = "yes".equals(stateVariable.getAttributes().getNamedItem("sendEvents").getTextContent());
                        vars.put(name,
                                new UpnpStateVariable(
                                        name,
                                        UpnpDatatype.valueOf(dataType),
                                        sendsEvents,
                                        ImmutableList.copyOf(allowedValueList),
                                        allowedValueRange
                                        ));
                    }
                }
            }
        }
        final List<UpnpAction> actions = new ArrayList<UpnpAction>();
        for (int i = 0; i< length; i++) {
            final Node item = childNodes.item(i);
            if ("actionList".equals(item.getNodeName())) {
                // each action is a service method
                NodeList actionNodes = item.getChildNodes();
                for (int i2 = 0; i2 < actionNodes.getLength(); i2++) {
                    Node actionNode = actionNodes.item(i2);
                    if ("action".equals(actionNode.getNodeName())) {
                        String name = null;
                        List<UpnpActionArgument> inputArguments = new ArrayList<UpnpActionArgument>();
                        List<UpnpActionArgument> outputArguments = new ArrayList<UpnpActionArgument>();
                        NodeList actionChildNodes = actionNode.getChildNodes();
                        for (int i3=0; i3 < actionChildNodes.getLength(); i3++) {
                            Node actionChildNode = actionChildNodes.item(i3);
                            String actionChildNodeName = actionChildNode.getNodeName();
                            if ("name".equals(actionChildNodeName)) {
                                name = actionChildNode.getTextContent();
                            } else if ("argumentList".equals(actionChildNodeName)) {
                                NodeList argumentNodes = actionChildNode.getChildNodes();
                                for (int i4 = 0; i4 < argumentNodes.getLength(); i4++) {
                                    Node argumentNode = argumentNodes.item(i4);
                                    if ("argument".equals(argumentNode.getNodeName())) {

                                        String anName = null;
                                        String anRelatedStateVariableName = null;
                                        String anDirection = null;
                                        NodeList argumentChildNodes = argumentNode.getChildNodes();
                                        for (int i5 = 0; i5 < argumentChildNodes.getLength(); i5++) {
                                            Node argumentChildNode = argumentChildNodes.item(i5);
                                            String argumentChildNodeName = argumentChildNode.getNodeName();
                                            if ("name".equals(argumentChildNodeName)) {
                                                anName = argumentChildNode.getTextContent();
                                            }
                                            if ("direction".equals(argumentChildNodeName)) {
                                                anDirection = argumentChildNode.getTextContent();
                                            }
                                            if ("relatedStateVariable".equals(argumentChildNodeName)) {
                                                anRelatedStateVariableName = argumentChildNode.getTextContent();
                                            }
                                        }
                                        Preconditions.checkNotNull(anName);
                                        Preconditions.checkNotNull(anDirection);
                                        Preconditions.checkNotNull(anRelatedStateVariableName);
                                        UpnpStateVariable relatedStateVariable = vars.get(anRelatedStateVariableName);
                                        Preconditions.checkNotNull(relatedStateVariable);
                                        UpnpActionArgument argument = new UpnpActionArgument(anName, relatedStateVariable);
                                        if ("in".equals(anDirection.toLowerCase())) {
                                            inputArguments.add(argument);
                                        } else {
                                            Preconditions.checkState("out".equals(anDirection.toLowerCase()));
                                            outputArguments.add(argument);
                                        }
                                    }
                                }
                            }
                        }

                        final UpnpAction action  = new UpnpAction(UpnpActionName.valueOf(name), ImmutableList.copyOf(inputArguments), ImmutableList.copyOf(outputArguments));
                        actions.add(action);
                    }
                }
            }
        }
        return new UpnpService(sname, ImmutableList.copyOf(vars.values()), ImmutableList.copyOf(actions));
    }

    public static UpnpService read(String name, Document document) {
        return parseServiceDocument(name, document);
    }

    public static List<UpnpService> readTypeDescriptions(final File docDir) throws ParserConfigurationException, SAXException, IOException {
        final List<UpnpService> types = new ArrayList<UpnpService>();
        for (final File f : docDir.listFiles()) {
            if (!f.getName().endsWith(".xml")) {
                continue;
            }
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(f);
            final String name = getName(f);

            final UpnpService scdp = UpnpServiceReader.read(name, document);
            if (scdp != null) {

                types.add(scdp);
            }
        }
        return types;
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
