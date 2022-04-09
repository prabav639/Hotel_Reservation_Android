package com.example.hotel_application;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {

    @GET("/app/hotel_list")
    void getHotelsLists(Callback<List<HotelListData>> callback);

  @POST("/app/reservation/")
    void postGuestsLists(@Body ReservationFragment reservationFragment, Callback<String> callback);
}
