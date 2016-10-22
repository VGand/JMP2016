package com.epam.momgo;

import com.epam.momgo.beans.Transaction;
import com.epam.momgo.dao.*;
import com.epam.momgo.utils.DateFormatUtils;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Полина on 16.10.2016.
 */
public class MainMongo {

    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy-HH:mm";

    public static void main(String[] args) {
        MongoDatabase database = MongoConnection.getInstance().getDataBase("bank");
        System.out.println(database.getName());

        TransactionDao transactionDao = new TransactionDaoImpl();

        //Консоль
        int action = -1;
        Scanner scanner = new Scanner(System.in);
        while(action != 0) {
            System.out.println("1-Добавить транзакцию");
            System.out.println("2-Добавить категорию к транзакции");
            System.out.println("3-Список транзакции");
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


                    List<String> categoryList = new ArrayList<String>();
                    Integer categoryAction = -1;
                    while(categoryAction != 0) {
                        System.out.print("Введите наименование категории:");
                        String categoryName = scanner.next();
                        categoryList.add(categoryName);
                        System.out.println();

                        System.out.print("Для продолжения ввода категорий нажмите 1:");
                        if (!scanner.hasNextInt() || scanner.nextInt() != 1) {
                            categoryAction = 0;
                        }
                    }

                    transaction.setAmount(amount);
                    transaction.setCategoryList(categoryList);
                    transaction.setCurrency(currency);
                    transaction.setDateTime(LocalDateTime.now());
                    transaction.setRecipientCode(recipientCode);
                    transaction.setUuid(UUID.randomUUID());
                    transactionDao.addTransaction(transaction);
                    break;
                }
                case 2: {
                    //Добавление категории к транзакции
                    System.out.println("Добавление категории к транзакции");
                    System.out.print("Введите идентификатор транзакции:");
                    String id = scanner.next();
                    Transaction transaction = transactionDao.getTransactionById(UUID.fromString(id));
                    System.out.println();
                    System.out.print("Введите наименование категории:");
                    String categoryName = scanner.next();
                    transaction.getCategoryList().add(categoryName);
                    transactionDao.updateTransaction(transaction);
                    break;
                }
                case 3: {
                    //Список транзакции
                    System.out.println("Список транзакции:");
                    List<Transaction> transactionList = transactionDao.getTransactions();
                    for(Transaction transaction : transactionList) {
                        System.out.println(transaction.toString());
                    }
                    break;
                }
                case 4: {
                    //Фильтр списка транзакций по дате
                    System.out.println("Введите начальную дату в формате (дд.мм.гггг-чч:мм):");
                    LocalDateTime startDate = DateFormatUtils.getDateTimeByFormat(scanner.next(), DATE_TIME_FORMAT);
                    System.out.println("Введите конечную дату в формате (дд.мм.гггг-чч:мм):");
                    LocalDateTime endDate = DateFormatUtils.getDateTimeByFormat(scanner.next(), DATE_TIME_FORMAT);
                    List<Transaction> transactionList = transactionDao.getTransactionsByDateTime(startDate, endDate);
                    for(Transaction transaction : transactionList) {
                        System.out.println(transaction.toString());
                    }
                    break;
                }
                case 5: {
                    //Фильтр списка транзакций по валюте
                    System.out.println("Введите наименование валюты:");
                    String currency = scanner.next();
                    List<Transaction> transactionList = transactionDao.getTransactionsByCurrency(currency);
                    for(Transaction transaction : transactionList) {
                        System.out.println(transaction.toString());
                    }
                    break;
                }
                case 6: {
                    //Фильтр транзакций по категориям
                    System.out.println("Введите наименование категории:");
                    String category = scanner.next();
                    List<Transaction> transactionList = transactionDao.getTransactionsByCategory(category);
                    for(Transaction transaction : transactionList) {
                        System.out.println(transaction.toString());
                    }
                    break;
                }
            }
        }
    }
}
