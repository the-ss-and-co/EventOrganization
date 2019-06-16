package com.Myproject.myapp.Model;

public class Equipmentmodel {
    String equipment_name;
    String price_rent;

    public Equipmentmodel(String equipment_name, String price_rent) {
        this.equipment_name = equipment_name;
        this.price_rent = price_rent;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getPrice_rent() {
        return price_rent;
    }

    public void setPrice_rent(String price_rent) {
        this.price_rent = price_rent;
    }
}
