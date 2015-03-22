package no.nith.pg6100;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.nio.file.Paths;

public class Parser {

    public static void main(String[] args) throws JAXBException, SAXException {
        File schemaDocument = Paths.get("src/main/resources/schema1.xsd").toFile();
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaDocument);

        JAXBContext context = JAXBContext.newInstance(Order.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);

        Order order = (Order) unmarshaller.unmarshal(xmlDocument);
        order.getOrderLines().stream().forEach(System.out::println);
    }
}
