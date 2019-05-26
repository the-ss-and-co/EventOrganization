package com.Myproject.myapp.Model;

public class Service4item {
    String item;
    String date;
    String amount;

    public Service4item(String item, String date, String amount) {
        this.item = item;
        this.date = date;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
