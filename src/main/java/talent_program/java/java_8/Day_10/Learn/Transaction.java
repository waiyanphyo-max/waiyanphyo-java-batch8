package main.java.talent_program.java.java_8.Day_10.Learn;

import java.time.LocalDateTime;

public class Transaction {
    private int tran_id;
    private String tran_type;
    private String tran_category;
    private Double amount;
    private String note;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private int delete_flag;

    public Transaction() {
    }

    public Transaction(int tran_id, String tran_type, String tran_category, Double amount, String note, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime deleted_at, int delete_flag) {
        this.tran_id = tran_id;
        this.tran_type = tran_type;
        this.tran_category = tran_category;
        this.amount = amount;
        this.note = note;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.delete_flag = delete_flag;
    }

    public int getTran_id() {
        return tran_id;
    }

    public void setTran_id(int tran_id) {
        this.tran_id = tran_id;
    }

    public String getTran_type() {
        return tran_type;
    }

    public void setTran_type(String tran_type) {
        this.tran_type = tran_type;
    }

    public String getTran_category() {
        return tran_category;
    }

    public void setTran_category(String tran_category) {
        this.tran_category = tran_category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDateTime deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(int delete_flag) {
        this.delete_flag = delete_flag;
    }
}
