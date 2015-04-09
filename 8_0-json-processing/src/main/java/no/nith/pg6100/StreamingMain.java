package no.nith.pg6100;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamingMain {

    public void write() throws IOException {
        JsonGenerator generator = Json.createGenerator(new FileWriter("test2.json"));
        generator.writeStartObject()
                    .writeStartObject("order")
                        .write("id", "123")
                        .write("date", "05/06/2014")
                        .writeStartArray("order_line")
                            .writeStartObject()
                                .write("item", "H2G2")
                                .write("quantity", "1")
                                .write("unit_price", "23.5")
                            .writeEnd()
                        .writeEnd()
                    .writeEnd()
                .writeEnd().close();
    }

    public void read() throws FileNotFoundException {
        JsonParser parser = Json.createParser(new FileReader("test2.json"));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            if (event.equals(JsonParser.Event.KEY_NAME) && parser.getString().equals("unit_price")) {
                parser.next();
                System.out.println(parser.getString());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamingMain main = new StreamingMain();
        main.write();
        main.read();
    }
}
