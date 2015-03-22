package no.nith.pg6100;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;

public class Parser {

    public static void main(String[] args) throws JAXBException {
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Order order = (Order) unmarshaller.unmarshal(xmlDocument);
        order.getOrderLines().stream().forEach(System.out::println);
    }
}
