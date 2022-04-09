package com.example.hotel_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    GuestDetailsListAdapter guestDetailsListAdapter;
    String numberOfGuests;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.guest_list_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String hotelName = getArguments().getString("name");
        String hotelPrice = getArguments().getString("price");
        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        numberOfGuests = getArguments().getString("number of guests");

        TextView hotelRecapTextView = view.findViewById(R.id.heading_text_view);
        hotelRecapTextView.setText("Hooray! You have Locked the Hotel : " +hotelName+ " @ $" + hotelPrice + " between " + checkInDate + " and " + checkOutDate + " & number of guests are " + numberOfGuests);


        Button bookBtn = view.findViewById(R.id.book_button);
        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<GuestListData> guestListData = guestDetailsListAdapter.getGuests();
                ReservationFragment reservationFragment = new ReservationFragment(hotelName, checkInDate, checkOutDate, guestListData);
//                progressBar.setVisibility(View.VISIBLE);
                Api.getClient().postGuestsLists(reservationFragment, new Callback<String>() {
                    @Override
                    public void success(String userListResponses, Response response) {
                        Log.e("Confirmation", userListResponses);
                    Intent intent = new Intent(getActivity(),ConfirmationActivity.class);
                    intent.putExtra("Confirmation_Number", userListResponses);
                    startActivity(intent);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();

                    }
                });
//                1 getvalue from recycler view
//                get by position from recycler
//                2 post request
//                3 display reservation number on another screen
            }
        });
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        guestDetailsListAdapter = new GuestDetailsListAdapter(getActivity(), numberOfGuests);
        recyclerView.setAdapter(guestDetailsListAdapter);
    }
}
