package no.nith.pg6100;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws TransformerException {
        File xsltFile = Paths.get("src/main/resources/order-html.xsl").toFile();
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltFile));

        transformer.transform(new StreamSource(xmlDocument), new StreamResult(new File("src/main/resources/index.html")));
    }
}
