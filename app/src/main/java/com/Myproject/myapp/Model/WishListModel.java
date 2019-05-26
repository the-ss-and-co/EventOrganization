package com.Myproject.myapp.Model;

public class WishListModel {
    String people_count,name,out_of_range,price;
    int img,star_count;

    public String getPeople_count() {
        return people_count;
    }

    public String getName() {
        return name;
    }

    public String getOut_of_range() {
        return out_of_range;
    }

    public String getPrice() {
        return price;
    }

    public int getStar_count() {
        return star_count;
    }

    public int getImg() {
        return img;
    }

    public WishListModel(String people_count, String name, String out_of_range, String price, int star_count, int img) {
        this.people_count = people_count;
        this.name = name;
        this.out_of_range = out_of_range;
        this.price = price;
        this.star_count = star_count;
        this.img = img;
    }
}
