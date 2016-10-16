package com.epam.momgo;

import com.epam.momgo.beans.Category;
import com.epam.momgo.beans.Transaction;
import com.epam.momgo.dao.*;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Полина on 16.10.2016.
 */
public class MainMongo {

    public static void main(String[] args) {
        MongoDatabase database = MongoConnection.getInstance().getDataBase("bank");
        System.out.println(database.getName());

        CategoriesDao categoriesDao = new CategoriesDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();

        //Консоль
        int action = -1;
        Scanner scanner = new Scanner(System.in);
        while(action != 0) {
            System.out.println("1-Добавить транзакцию");
            System.out.println("2-Добавить категорию");
            System.out.println("3-Добавить категорию к транзакции");
            System.out.println("4-Фильтр списка транзакций по дате");
            System.out.println("5-Фильтр списка транзакций по валюте");
            System.out.println("6-Фильтр списка транзакций по категориям");
            System.out.println("0-Выход");

            System.out.print("Ваш выбор:");
            action = scanner.nextInt();
            switch (action) {
                case 1: {
                    Transaction transaction = new Transaction();
                    //Добавление транзакции
                    System.out.println("Добавление новой транзакции");
                    System.out.print("Введите сумму:");
                    Double amount = scanner.nextDouble();
                    System.out.print("Введите наименование валюты:");
                    String currency = scanner.next();
                    System.out.print("Введите код:");
                    Integer recipientCode = scanner.nextInt();
                    System.out.print("Введите наименование категории:");
                    String categoryName = scanner.next();
                    Category category = categoriesDao.getCategoryByName(categoryName);

                    transaction.setAmount(amount);
                    transaction.setCategory(category);
                    transaction.setCurrency(currency);
                    transaction.setDateTime(LocalDateTime.now());
                    transaction.setRecipientCode(recipientCode);
                    transactionDao.addTransaction(transaction);
                    break;
                }
                case 2: {
                    //Добавление категории
                    System.out.println("Добавление новой категории");
                    System.out.print("Введите наименование категории:");
                    Category category = new Category();
                    category.setCategoryName(scanner.next());
                    break;
                }
                case 3: {
                    //Добавление категории к транзакции
                    System.out.println("Добавление категории к транзакции");
                    System.out.print("Введите идентификатор транзакции:");
                    Integer id = scanner.nextInt();
                    Transaction transaction = transactionDao.getTransactionById(id);
                    System.out.println();
                    System.out.print("Введите наименование категории:");
                    String categoryName = scanner.next();
                    Category category = categoriesDao.getCategoryByName(categoryName);
                    transaction.setCategory(category);
                    transactionDao.updateTransaction(transaction);
                    break;
                }
                case 4: {
                    //Фильтр списка транзакций по дате
                    List<Transaction> transactionList = transactionDao.getTransactions();
                    for(Transaction transaction : transactionList) {
                        System.out.println(transaction.toString());
                    }
                    break;
                }
                case 5: {
                    //Фильтр списка транзакций по валюте
                    break;
                }
                case 6: {
                    //Фильтр транзакций по категориям
                    break;
                }
            }
        }
    }
}
