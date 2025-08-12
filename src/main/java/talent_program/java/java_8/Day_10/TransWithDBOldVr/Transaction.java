package main.java.talent_program.java.java_8.Day_10.TransWithDBOldVr;

import java.time.LocalDateTime;

public class Transaction {
    private long id = System.currentTimeMillis();
    private TransType transType;
    private Category category;
    private double amount;
    private LocalDateTime transDate;
    private String note;

    public Transaction(long id, TransType transType, Category category, double amount, LocalDateTime transDate, String note) {
        this.id = id;
        this.transType = transType;
        this.category = category;
        this.amount = amount;
        this.transDate = transDate;
        this.note = note;
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

    public LocalDateTime getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDateTime transDate) {
        this.transDate = transDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transType=" + transType +
                ", category=" + category +
                ", amount=" + amount +
                ", note=" + note +
                ", transDate=" + transDate +
                '}';
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
