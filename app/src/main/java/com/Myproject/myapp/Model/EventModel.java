package com.Myproject.myapp.Model;

public class EventModel {
    String EventText;
    int image;
    boolean isval;

    public boolean isIsval() {
        return isval;
    }

    public void setIsval(boolean isval) {
        this.isval = isval;
    }

    public EventModel(String eventText, int image,boolean isval){
        this.EventText= eventText;
        this.image = image;
        this.isval=isval;
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
