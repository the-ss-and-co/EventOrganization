package com.Myproject.myapp.Model;

public class PriceItem {
    String item_name;
    String price;

    public PriceItem(String item_name, String price) {
        this.item_name = item_name;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
