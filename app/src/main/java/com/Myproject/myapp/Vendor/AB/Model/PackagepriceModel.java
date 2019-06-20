package com.Myproject.myapp.Vendor.AB.Model;

public class PackagepriceModel {
    String price_amount;
    String original_amount;
    String discount_amount;

    public PackagepriceModel(String price_amount, String original_amount, String discount_amount) {
        this.price_amount = price_amount;
        this.original_amount = original_amount;
        this.discount_amount = discount_amount;
    }

    public String getPrice_amount() {
        return price_amount;
    }

    public void setPrice_amount(String price_amount) {
        this.price_amount = price_amount;
    }

    public String getOriginal_amount() {
        return original_amount;
    }

    public void setOriginal_amount(String original_amount) {
        this.original_amount = original_amount;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }
}
