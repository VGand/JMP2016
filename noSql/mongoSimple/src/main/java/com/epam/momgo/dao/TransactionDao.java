package com.epam.momgo.dao;

import com.epam.momgo.beans.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by Полина on 16.10.2016.
 */
public interface TransactionDao {

    void addTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    Transaction getTransactionById(UUID id);

    List<Transaction> getTransactions();

    List<Transaction> getTransactionsByDateTime(LocalDateTime startDate, LocalDateTime endDateTime);

    List<Transaction> getTransactionsByCurrency(String currency);

    List<Transaction> getTransactionsByCategory(String categoryName);
}
