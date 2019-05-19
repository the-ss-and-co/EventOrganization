package com.Myproject.myapp.Model;

public class NewDateModel {
    String item;
    String date;
    public NewDateModel(){

    }
    public NewDateModel(String item, String date) {
        this.item = item;
        this.date = date;
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
}
