package com.Myproject.myapp.Model;

public class BokingItem {
    String item;
    String day;
    String day_of_daate;

    public BokingItem(String item, String day, String day_of_daate) {
        this.item = item;
        this.day = day;
        this.day_of_daate = day_of_daate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay_of_daate() {
        return day_of_daate;
    }

    public void setDay_of_daate(String day_of_daate) {
        this.day_of_daate = day_of_daate;
    }
}
