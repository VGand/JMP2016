package com.epam.momgo.dao;

import com.epam.momgo.beans.Category;
import com.epam.momgo.beans.Transaction;
import com.epam.momgo.utils.JSONConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    }

    public Transaction getTransactionById(Integer id) {
        return null;
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
        return null;
    }

    public List<Transaction> getTransactionsByCurrency(String currency) {
        return null;
    }

    public List<Transaction> getTransactionsByCategory(Category category) {
        return null;
    }
}
