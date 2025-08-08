package main.java.talent_program.java.java_8.Day_9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private long id = System.currentTimeMillis();
    private TransType transType;
    private Category category;
    private double amount;
    private LocalDate transDate;

    public Transaction(long id, TransType transType, Category category, double amount, LocalDate transDate) {
        this.id = id;
        this.transType = transType;
        this.category = category;
        this.amount = amount;
        this.transDate = transDate;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transType=" + transType +
                ", category=" + category +
                ", amount=" + amount +
                ", transDate=" + transDate +
                '}';
    }
}
