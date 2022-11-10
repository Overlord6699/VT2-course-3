package dao.implementation;

import dao.ApplianceDAO;
import entity.*;
import entity.property.SearchPropertiesContainer;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String pathToFile = "resources\\appliances.xml";

    /** Find appliance among xml file
     * {@inheritDoc}
     */
    @Override
    public List<Appliance> findAppliance(SearchPropertiesContainer criteria) throws ParserConfigurationException, IOException, SAXException {
        Document document = getDocument();
        return getResultAppliances(document.getElementsByTagName(criteria.getSearchCategory()), criteria);
    }

    private Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        return documentBuilder.parse(new File(pathToFile));
    }

    private boolean isMatch(NodeList fields, SearchPropertiesContainer criteria) {
        boolean isMatch = true;

        for (int i = 0; i < fields.getLength() && isMatch; i++) {
            if (fields.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String name = fields.item(i).getNodeName();
                String value = fields.item(i).getTextContent();

                if (criteria.getSearchProperties().containsKey(name) &&
                        !criteria.getSearchProperties().get(name).toString().equals(value)) {
                    isMatch = false;
                }
            }
        }

        return isMatch;
    }

    private List<Appliance> getResultAppliances(NodeList nodeList, SearchPropertiesContainer criteria) {
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (isMatch(node.getChildNodes(), criteria)) {
                appliances.add(mapNodeToAppliance(node));
            }
        }

        return appliances;
    }

    private Appliance mapNodeToAppliance(Node node) {
        String[] fields = getFieldsArray(node.getChildNodes());

        if (node.getNodeName().equals(Oven.class.getSimpleName())) {
            return new Oven(fields);
        } else if (node.getNodeName().equals(Laptop.class.getSimpleName())) {
            return new Laptop(fields);
        } else if (node.getNodeName().equals(Fridge.class.getSimpleName())) {
            return new Fridge(fields);
        } else if (node.getNodeName().equals(Kettle.class.getSimpleName())) {
            return new Kettle(fields);
        } else if (node.getNodeName().equals(Speakers.class.getSimpleName())) {
            return new Speakers(fields);
        } else  if (node.getNodeName().equals(WashingMachine.class.getSimpleName())) {
            return new WashingMachine(fields);
        }

        return null;
    }

    private String[] getFieldsArray(NodeList fieldsNodes) {
        String[] fields = new String[fieldsNodes.getLength() / 2];

        int index = 0;
        for (int j = 0; j < fieldsNodes.getLength(); j++) {
            if (fieldsNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                fields[index++] = fieldsNodes.item(j).getTextContent();
            }
        }

        return fields;
    }
}
