package com.example.hotel_application;

import java.util.ArrayList;

public class ReservationFragment {

    String hotel;
    String checkin;

    public ReservationFragment(String hotel, String checkin, String checkout, ArrayList<GuestListData> guest) {
        this.hotel = hotel;
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest = guest;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public ArrayList<GuestListData> getGuest() {
        return guest;
    }

    public void setGuest(ArrayList<GuestListData> guest) {
        this.guest = guest;
    }

    String checkout;
    ArrayList<GuestListData> guest;

}
