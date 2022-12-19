package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private EditText email;
    private EditText numid;
    private EditText number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =  findViewById(R.id.user);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        numid= findViewById(R.id.numid);
    }

    public void signup(View view) {
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }

    public void login(View view) {
        Intent in = new Intent(this,LogIn.class);
        startActivity(in);
    }
}