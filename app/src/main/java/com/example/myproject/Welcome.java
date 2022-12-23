package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    public void signup(View view) {

        Intent in = new Intent(this, SignUp.class);
        startActivity(in);
    }

    public void login(View view) {
        Intent in = new Intent(this, LogIn.class);
        startActivity(in);
    }

    public void Gallery(View view) {
        Intent in = new Intent(this, Gallery.class);
        startActivity(in);
    }
}

