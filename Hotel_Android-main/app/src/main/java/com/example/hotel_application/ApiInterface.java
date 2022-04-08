package com.example.hotel_application;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {

    @GET("/app/hotel_list")
    void getHotelsLists(Callback<List<HotelListData>> callback);
    
}
