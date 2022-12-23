package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText email;
    private EditText numid;
    private EditText number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }



    public void login(View view) {
        Intent in = new Intent(this, LogIn.class);
        startActivity(in);
    }

    public void btnH(View view) {
        Intent in = new Intent(this, Home.class);
        startActivity(in);
    }
}
