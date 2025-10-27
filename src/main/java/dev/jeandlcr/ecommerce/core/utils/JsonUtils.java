package dev.jeandlcr.ecommerce.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonUtils {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Error converting JSON to object", e);
        }
    }

    public static String prettyPrint(String json) {
        try {
            return gson.toJson(JsonParser.parseString(json));
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Error formatting JSON", e);
        }
    }

    public static boolean isValidJson(String json) {
        try {
            JsonParser.parseString(json);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    public static Gson getGson() {
        return gson;
    }
}
