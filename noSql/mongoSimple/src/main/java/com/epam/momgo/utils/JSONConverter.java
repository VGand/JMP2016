package com.epam.momgo.utils;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by Полина on 16.10.2016.
 */
public class JSONConverter {
    static public <T> T getObject(String json, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    static public String getJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
