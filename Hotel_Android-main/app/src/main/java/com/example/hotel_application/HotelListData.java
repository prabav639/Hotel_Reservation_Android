package com.example.hotel_application;

public class HotelListData {

    String name;
    String price;
    String available;

    public HotelListData(String name, String price, String available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getHotel_name() {
        return name;
    }

    public void setHotel_name(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return available;
    }

    public void setAvailability(String available) {
        this.available = available;
    }
}
