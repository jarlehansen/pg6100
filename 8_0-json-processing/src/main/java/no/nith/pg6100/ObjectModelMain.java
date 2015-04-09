package no.nith.pg6100;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ObjectModelMain {

    public void write() throws IOException {
        JsonObject jsonObject = Json.createObjectBuilder().add("order",
                Json.createObjectBuilder()
                        .add("id", "123")
                        .add("date", "05/06/2014")
                        .add("order_line", Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("item", "H2G2")
                                        .add("quantity", "1")
                                        .add("unit_price", "23.5")))
        ).build();

        JsonWriter writer = Json.createWriter(new FileWriter("test.json"));
        writer.write(jsonObject);
        writer.close();
    }

    public void read() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("test.json"));
        JsonStructure jsonStructure = reader.read();
        System.out.println(jsonStructure.toString());
    }

    public static void main(String[] args) throws IOException {
        ObjectModelMain objectModelMain = new ObjectModelMain();
        objectModelMain.write();
        objectModelMain.read();
    }
}
