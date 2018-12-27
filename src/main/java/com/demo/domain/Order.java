package com.demo.domain;

import java.util.Date;

public class Order {
    private String orderCard;
    private int id;
    private int number;
    private Date createTime;
    private String note;

    public String getOrderCard() {
        return orderCard;
    }

    public void setOrderCard(String orderCard) {
        this.orderCard = orderCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
