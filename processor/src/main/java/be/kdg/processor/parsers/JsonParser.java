package be.kdg.processor.parsers;

import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

@Component
public class JsonParser {
    public JsonObject convert(String json) {
        JsonReader jsonReader = Json.createReader(new StringReader(json));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        return object;
    }
}
