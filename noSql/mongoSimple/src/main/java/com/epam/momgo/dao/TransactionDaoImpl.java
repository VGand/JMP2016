package com.epam.momgo.dao;

import com.epam.momgo.beans.Transaction;
import com.epam.momgo.utils.JSONConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Полина on 16.10.2016.
 */
public class TransactionDaoImpl implements TransactionDao{

    private final String TRANSACTION_DB_NAME = "bank";
    private final String TRANSACTION_COLLECTION_NAME = "transaction";

    public void addTransaction(Transaction transaction) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        Document transactionDoc = Document.parse(JSONConverter.getJson(transaction));

        collection.insertOne(transactionDoc);
    }

    public void updateTransaction(Transaction transaction) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("uuid", transaction.getUuid());

        collection.findOneAndUpdate(whereQuery, Document.parse(JSONConverter.getJson(transaction)));
    }

    public Transaction getTransactionById(UUID id) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("uuid", id);

        Document transactionDoc = collection.find(whereQuery).first();
        return JSONConverter.getObject(transactionDoc.toJson(), Transaction.class);
    }

    public List<Transaction> getTransactions() {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        List<Transaction> transactions = new ArrayList<Transaction>();
        MongoCursor<Document> iterator =  collection.find().iterator();

        while(iterator.hasNext()){
            Document transactionDoc = iterator.next();
            Transaction transaction = JSONConverter.getObject(transactionDoc.toJson(), Transaction.class);
            transactions.add(transaction);
        }

        return transactions;
    }

    public List<Transaction> getTransactionsByDateTime(LocalDateTime startDate, LocalDateTime endDateTime) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        BasicDBObject condition = new BasicDBObject(2);

        Instant startInstant = startDate.atZone(ZoneId.systemDefault()).toInstant();
        Date start = Date.from(startInstant);
        condition.put("$gte", start.getTime());

        Instant endInstant = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date end = Date.from(endInstant);
        condition.put("$lt", end);

        MongoCursor<Document> iterator =  collection.find(new BasicDBObject("dateTime", condition)).iterator();
        List<Transaction> transactions = new ArrayList<Transaction>();

        while(iterator.hasNext()){
            Document transactionDoc = iterator.next();
            Transaction transaction = JSONConverter.getObject(transactionDoc.toJson(), Transaction.class);
            transactions.add(transaction);
        }

        return transactions;
    }

    public List<Transaction> getTransactionsByCurrency(String currency) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        BasicDBObject condition = new BasicDBObject();
        condition.put("currency", currency);
        MongoCursor<Document> iterator =  collection.find(condition).iterator();
        List<Transaction> transactions = new ArrayList<Transaction>();

        while(iterator.hasNext()){
            Document transactionDoc = iterator.next();
            Transaction transaction = JSONConverter.getObject(transactionDoc.toJson(), Transaction.class);
            transactions.add(transaction);
        }

        return transactions;
    }

    public List<Transaction> getTransactionsByCategory(String categoryName) {
        MongoDatabase mongoDatabase = MongoConnection.getInstance().getDataBase(TRANSACTION_DB_NAME);
        MongoCollection<Document> collection = mongoDatabase.getCollection(TRANSACTION_COLLECTION_NAME);

        BasicDBObject condition = new BasicDBObject("categoryList",categoryName);
        MongoCursor<Document> iterator =  collection.find(condition).iterator();
        List<Transaction> transactions = new ArrayList<Transaction>();

        while(iterator.hasNext()){
            Document transactionDoc = iterator.next();
            Transaction transaction = JSONConverter.getObject(transactionDoc.toJson(), Transaction.class);
            transactions.add(transaction);
        }

        return transactions;
    }
}
