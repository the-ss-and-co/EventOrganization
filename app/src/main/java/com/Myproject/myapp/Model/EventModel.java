package com.Myproject.myapp.Model;

public class EventModel {
    String EventText;
    int image;

     public EventModel(String eventText, int image){
        this.EventText= eventText;
        this.image = image;
    }

    public String getEventText() {
        return EventText;
    }

    public void setEventText(String eventText) {
        EventText = eventText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
