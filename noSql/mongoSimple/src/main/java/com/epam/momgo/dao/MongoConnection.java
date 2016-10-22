package com.epam.momgo.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Полина on 16.10.2016.
 */
public class MongoConnection {
    private static MongoConnection mongoConnection = null;

    private MongoClient mongoClient;

    private MongoConnection() {
        mongoClient = new MongoClient("localhost", 27017);
    }

    public static MongoConnection getInstance() {
        if (mongoConnection == null) {
            mongoConnection = new MongoConnection();
        }
        return mongoConnection;
    }

    public MongoDatabase getDataBase(String databaseName) {
        return mongoClient.getDatabase(databaseName);
    }
}
