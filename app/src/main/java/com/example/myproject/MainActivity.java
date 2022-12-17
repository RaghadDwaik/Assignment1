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
    private EditText pass;
    private EditText email;
    private EditText national;
    private EditText number;
    private RadioButton male;
    private RadioButton female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =  findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        national= findViewById(R.id.national);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);


    }

    public void btnSignUp(View view) {
        String msg =" HI LOGIN";
        Intent in = new Intent(this,LogIn.class);
        in.putExtra("data",msg);
        startActivity(in);

    }

    public void login(View view) {

        String msg =" HI LOGIN";
        Intent in = new Intent(this,LogIn.class);
        in.putExtra("data",msg);
        startActivity(in);
    }
}