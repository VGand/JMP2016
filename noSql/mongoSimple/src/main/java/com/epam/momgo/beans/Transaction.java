package com.epam.momgo.beans;


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Полина on 16.10.2016.
 */
public class Transaction {
    private Double amount;
    private String currency;
    private LocalDateTime dateTime;
    private Integer recipientCode;
    private Integer id;
    private Category category;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(Integer recipientCode) {
        this.recipientCode = recipientCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", recipientCode=" + recipientCode +
                ", id=" + id +
                ", category=" + category +
                '}';
    }
}
