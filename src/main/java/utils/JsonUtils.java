package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    public static JsonNode getJsonNodeByFile(File file) {
        try { return new ObjectMapper().readTree(file); }
        catch (IOException e) { throw new RuntimeException(e); }
    }

    public static String getStringValue(JsonNode json, String path) {
        return json.at(path).textValue();
    }

    public static Integer getIntValue(JsonNode json, String path) {
        return json.at(path).intValue();
    }
}