package com.Myproject.myapp.Model;

public class PastDataModel {
    String festive_calender;
    String date;
    String event_type;
    String event_name;

    public PastDataModel(String festive_calender, String date, String event_type, String event_name) {
        this.festive_calender = festive_calender;
        this.date = date;
        this.event_type = event_type;
        this.event_name = event_name;
    }

    public String getFestive_calender() {
        return festive_calender;
    }

    public void setFestive_calender(String festive_calender) {
        this.festive_calender = festive_calender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
}
