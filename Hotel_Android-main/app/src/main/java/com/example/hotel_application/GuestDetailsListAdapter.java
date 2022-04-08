package com.example.hotel_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GuestDetailsListAdapter extends RecyclerView.Adapter<GuestDetailsListAdapter.ViewHolder> {

    private int numberOfGuests;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    GuestDetailsListAdapter(Context context, int numberOfGuests) {
        this.layoutInflater = LayoutInflater.from(context);
        this.numberOfGuests = numberOfGuests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberOfGuests;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView guestNameTextView, guestGenderTextView;
        EditText guestNameEditText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            guestNameTextView = itemView.findViewById(R.id.guest_name_text_view);
//            guestNameEditText = itemView.findViewById(R.id.guest_name_edit_text);
//            guestGenderTextView = itemView.findViewById(R.id.gender_text_view);
//            hotelPrice = itemView.findViewById(R.id.gender_radio_group);

        }
    }
}