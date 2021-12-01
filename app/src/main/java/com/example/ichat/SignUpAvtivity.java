package com.example.ichat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.example.ichat.Models.Users;
import com.example.ichat.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpAvtivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;

    FirebaseDatabase database;
    ProgressDialog progressDialog;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(SignUpAvtivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("we are creating your account");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString() , binding.etPassword.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressDialog.dismiss();
                                if(task.isSuccessful()){
                                    Users user = new Users(binding.etUsername.getText().toString(), binding.etEmail.getText().toString(),
                                            binding.etPassword.getText().toString());

                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(user);

                                    Toast.makeText(SignUpAvtivity.this, "User Created Sucessfully", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(SignUpAvtivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        binding.tvAlreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpAvtivity.this , SignInActivity.class);
                startActivity(intent);
            }
        });

    }
}