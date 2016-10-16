package com.epam.momgo.dao;

import com.epam.momgo.beans.Category;
import com.epam.momgo.beans.Transaction;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Полина on 16.10.2016.
 */
public interface TransactionDao {

    void addTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    Transaction getTransactionById(Integer id);

    List<Transaction> getTransactions();

    List<Transaction> getTransactionsByDateTime(LocalDateTime startDate, LocalDateTime endDateTime);

    List<Transaction> getTransactionsByCurrency(String currency);

    List<Transaction> getTransactionsByCategory(Category category);
}
