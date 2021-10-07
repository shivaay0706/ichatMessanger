package com.example.ichat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.ichat.databinding.ActivitySignUpBinding;

public class SignUpAvtivity<FirebaseAuth> extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        
    }
}