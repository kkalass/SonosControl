package de.kalass.sonoscontrol.api.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import de.kalass.sonoscontrol.api.generator.SCDP.Action;
import de.kalass.sonoscontrol.api.generator.SCDP.ActionArgument;
import de.kalass.sonoscontrol.api.generator.SCDP.AllowedValueRange;
import de.kalass.sonoscontrol.api.generator.SCDP.StateVariable;

public final class SCDPReader {

    private SCDPReader() {
        // utility constructor
    }
    @CheckForNull
    private static SCDP parseServiceDocument(String sname, Document document) {
        Node root = document.getChildNodes().item(0);
        if (!"scpd".equals(root.getNodeName())) {
            return null;
        }

        final NodeList childNodes = root.getChildNodes();
        final int length = childNodes.getLength();
        final Map<String, StateVariable> vars = Maps.newHashMap();
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
                        AllowedValueRange allowedValueRange = null;
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
                                allowedValueRange = new AllowedValueRange(minimum, maximum, step);
                            }

                        }
                        Preconditions.checkNotNull(name);
                        Preconditions.checkNotNull(dataType);
                        vars.put(name,
                                new StateVariable(
                                        name,
                                        UpnpDatatype.valueOf(dataType),
                                        ImmutableList.copyOf(allowedValueList),
                                        allowedValueRange
                                        ));
                    }
                }
            }
        }
        final List<Action> actions = new ArrayList<Action>();
        for (int i = 0; i< length; i++) {
            final Node item = childNodes.item(i);
            if ("actionList".equals(item.getNodeName())) {
                // each action is a service method
                NodeList actionNodes = item.getChildNodes();
                for (int i2 = 0; i2 < actionNodes.getLength(); i2++) {
                    Node actionNode = actionNodes.item(i2);
                    if ("action".equals(actionNode.getNodeName())) {
                        String name = null;
                        List<ActionArgument> inputArguments = new ArrayList<ActionArgument>();
                        List<ActionArgument> outputArguments = new ArrayList<ActionArgument>();
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
                                        StateVariable relatedStateVariable = vars.get(anRelatedStateVariableName);
                                        Preconditions.checkNotNull(relatedStateVariable);
                                        ActionArgument argument = new ActionArgument(anName, relatedStateVariable);
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

                        final Action action  = new Action(UpnpActionName.valueOf(name), ImmutableList.copyOf(inputArguments), ImmutableList.copyOf(outputArguments));
                        actions.add(action);
                    }
                }
            }
        }
        return new SCDP(sname, ImmutableList.copyOf(vars.values()), ImmutableList.copyOf(actions));
    }

    public static SCDP read(String name, Document document) {
        return parseServiceDocument(name, document);
    }
}
