package com.Myproject.myapp.Model;

public class BillsItem {
    String vendarname;
    String boking_time;
    String event_type;
    String Amount;

    public BillsItem(String vendarname, String boking_time, String event_type, String amount) {
        this.vendarname = vendarname;
        this.boking_time = boking_time;
        this.event_type = event_type;
        Amount = amount;
    }

    public String getVendarname() {
        return vendarname;
    }

    public void setVendarname(String vendarname) {
        this.vendarname = vendarname;
    }

    public String getBoking_time() {
        return boking_time;
    }

    public void setBoking_time(String boking_time) {
        this.boking_time = boking_time;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
