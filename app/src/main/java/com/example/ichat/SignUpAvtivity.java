package com.example.ichat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SignUpAvtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_avtivity);

        getSupportActionBar().hide();
    }
}