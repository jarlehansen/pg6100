package no.nith.pg6100;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Parser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlDocument);

        NodeList nodes = document.getElementsByTagName("order_line");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Item: " + node.getAttributes().getNamedItem("item").getNodeValue());
            System.out.println("Quantity: " + node.getAttributes().getNamedItem("quantity").getNodeValue());

            Node item1 = node.getChildNodes().item(1);
            System.out.println("Unit price: " + item1.getFirstChild().getNodeValue() + "\n");
        }
    }
}
