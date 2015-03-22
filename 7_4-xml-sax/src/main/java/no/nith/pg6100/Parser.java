package no.nith.pg6100;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Parser extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        println("qName", qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String attrName = attributes.getQName(i);
            String attrValue = attributes.getValue(i);
            println(attrName, attrValue);
        }
        System.out.println("\n");
    }

    private void println(String key, String value) {
        System.out.println(String.format("%s: %s", key, value));
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(xmlDocument, new Parser());
    }
}
