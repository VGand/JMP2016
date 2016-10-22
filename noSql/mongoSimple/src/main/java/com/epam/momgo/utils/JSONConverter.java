package com.epam.momgo.utils;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Полина on 16.10.2016.
 */
public class JSONConverter {
    static public <T> T getObject(String json, Class<T> type) {

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                Long dateTimeMiles = ((JsonObject) json).get("$numberLong").getAsLong();
                Instant instant = Instant.ofEpochMilli(dateTimeMiles);
                return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            }
        }).create();

        return gson.fromJson(json, type);
    }

    static public String getJson(Object obj) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
                Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
                Date date = Date.from(instant);
                return new JsonPrimitive(date.getTime());
            }
        }).create();
        return gson.toJson(obj);
    }
}
