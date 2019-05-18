package com.Myproject.myapp.Model;

public class UpcomingModel {
    String name,service_name,event_name,total_pay,due_pay,code;

    public String getName() {
        return name;
    }

    public String getService_name() {
        return service_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getTotal_pay() {
        return total_pay;
    }

    public String getDue_pay() {
        return due_pay;
    }

    public String getCode() {
        return code;
    }

    public UpcomingModel(String name, String service_name, String event_name, String total_pay, String due_pay, String code) {
        this.name = name;
        this.service_name = service_name;
        this.event_name = event_name;
        this.total_pay = total_pay;
        this.due_pay = due_pay;
        this.code = code;
    }
}
