package com.example.hotel_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotel_application.R;

public class confirmationFragment extends Fragment {

    View view;
    String confirmation;
    TextView confirmationtextview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.confirmation_message_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        confirmationtextview = view.findViewById(R.id.confirmation_screen_text_view);

        confirmation = getArguments().getString("confirmation_number");

        confirmationtextview.setText(confirmation);
    }
}