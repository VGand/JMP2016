package com.epam.momgo.beans;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by Полина on 16.10.2016.
 */
public class Transaction {
    private Double amount;
    private String currency;
    private LocalDateTime dateTime;
    private Integer recipientCode;
    private UUID uuid;
    private List<String> categoryList;

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", dateTime=" + dateTime +
                ", recipientCode=" + recipientCode +
                ", id=" + uuid +
                ", categoryList=" + categoryList +
                '}';
    }
}
