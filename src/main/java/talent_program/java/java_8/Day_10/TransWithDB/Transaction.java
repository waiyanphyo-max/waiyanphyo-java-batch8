package main.java.talent_program.java.java_8.Day_10.TransWithDB;

import java.time.LocalDateTime;

public class Transaction {
    private int tran_id;
    private TransType tran_type;
    private TranCategory tranCategory;
    private Double amount;
    private String note;
    private LocalDateTime  created_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;
    private int delete_flag;

    public Transaction() {
    }

    public int getTran_id() {
        return tran_id;
    }

    public void setTran_id(int tran_id) {
        this.tran_id = tran_id;
    }

    public TransType getTran_type() {
        return tran_type;
    }

    public void setTran_type(TransType tran_type) {
        this.tran_type = tran_type;
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

    public TranCategory getTranCategory() {
        return tranCategory;
    }

    public void setTranCategory(TranCategory tranCategory) {
        this.tranCategory = tranCategory;
    }
}
