package com.example.hotel_application;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GuestDetailsListAdapter extends RecyclerView.Adapter<GuestDetailsListAdapter.ViewHolder> {

    private int numberOfGuests;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;
    ArrayList<GuestListData> guestList = new ArrayList<>();

    GuestDetailsListAdapter(Context context, String numberOfGuests) {
        this.layoutInflater = LayoutInflater.from(context);
        this.numberOfGuests = Integer.valueOf(numberOfGuests);
    }
public ArrayList<GuestListData> getGuests(){
        return guestList;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);


//        guestList.clear();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position == numberOfGuests-1) {
            for (int i = 0; i < numberOfGuests; i++) {
                GuestListData guestListData = new GuestListData();
                guestList.add(guestListData);
            }
        }
    holder.guestNameEditText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            guestList.get(position).setGuest_name(editable.toString());

        }
    });
        holder.gender_button.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==0)
                    guestList.get(position).setGender("F");
                else
                    guestList.get(position).setGender("M");
            }
        });
//holder.gender_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean checkedId) {
//        if(!checkedId)
//            guestList.get(position).setGender("F");
//        else
//            guestList.get(position).setGender("M");
//    }
//});
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
        RadioGroup gender_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            guestNameTextView = itemView.findViewById(R.id.guest_name_text_view);
            guestNameEditText = itemView.findViewById(R.id.guest_name_edit_text);
            guestGenderTextView = itemView.findViewById(R.id.gender_text_view);
//            hotelPrice = itemView.findViewById(R.id.gender_radio_group);
            gender_button = itemView.findViewById((R.id.gender_radio_group));

        }
    }
}