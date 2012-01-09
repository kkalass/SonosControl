package de.kalass.sonoscontrol.clingimpl.services;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.NoSuchElementException;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public final class XMLUtil {

    public static final class Children {
        private final Multimap<String, Node> _childNodes;

        public Children(Multimap<String, Node> childNodes) {
            super();
            this._childNodes = childNodes;
        }

        /**
         * Returns the Node for the given Key, or null if none was found.
         * @param key
         * @return
         * @throws IllegalArgumentException if there are more than one items of the given key
         */
        @CheckForNull
        public Node getSingleItem(@Nonnull String key) {
            final Collection<Node> iterable = _childNodes.get(key);
            if (iterable.isEmpty()) {
                return null;
            }
            if (iterable.size() == 1) {
                return iterable.iterator().next();
            }
            throw new IllegalArgumentException("There is more than 1 item for " + key + " => " + iterable);
        }

        /**
         * Returns the Node for the given Key
         * @param key
         * @return
         * @throws NoSuchElementException if there is no item of the given name
         * @throws IllegalArgumentException if there are more than one items of the given key
         */
        @Nonnull
        public Node getUnique(@Nonnull String key) {
            return Iterables.getOnlyElement(_childNodes.get(key));
        }
        public Collection<Node> get(String key) {
            return _childNodes.get(key);
        }
    }
    private XMLUtil() {
    }

    public static String getVal(final Node node) {
        return getAttr(node, "val");
    }

    public static String getAttr(final Node node, String attrName) {
        return node.getAttributes().getNamedItem(attrName).getTextContent();
    }
    public static Boolean getBooleanAttr(final Node node, String attrName) {
        final String val = getAttr(node, attrName);
        return val == null ? null : "1".equals(val) || "true".equals(val);
    }

    public static Long getLongAttr(final Node node, String attrName) {
        final String val = getAttr(node, attrName);
        return val == null ? null : Long.parseLong(val, 10);
    }

    public static Boolean getBooleanVal(final Node node) {
        return getBooleanAttr(node, "val");
    }

    public static Long getLongVal(final Node node) {
        return getLongAttr(node, "val");
    }

    public static Node getRoot(String documentAsString) {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(new InputSource(
                    new StringReader(documentAsString)
                    ));
            return document.getFirstChild();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        } catch (SAXException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Node getChildNotNull(Node parent, String childName) {
        return Preconditions.checkNotNull(getChildren(parent).getSingleItem(childName), "did not find child " + childName + " in " + parent.getNodeName());
    }

    public static Children getChildren(Node parent) {
        final Multimap<String, Node> result = LinkedListMultimap.create();
        final NodeList children = parent.getChildNodes();
        final int max = children.getLength();
        for (int i = 0; i < max; i++) {
            Node item = children.item(i);
            result.put(item.getNodeName(), item);
        }
        return new Children(result);
    }
}
