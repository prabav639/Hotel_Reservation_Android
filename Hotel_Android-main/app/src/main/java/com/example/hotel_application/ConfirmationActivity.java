package com.example.hotel_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Intent intent = getIntent();
        String confirmation_number = intent.getStringExtra("Confirmation_Number");
        TextView confirmed = findViewById(R.id.confirmation_screen_text_view);

        confirmed.setText(confirmation_number);
    }
}