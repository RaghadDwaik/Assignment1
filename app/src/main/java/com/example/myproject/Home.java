package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void btnG(View view) {
        Intent in = new Intent(this,Gallery.class);
        startActivity(in);
    }

    public void btnR(View view) {
        Intent in = new Intent(this,Room.class);
        startActivity(in);
    }

    public void btnP(View view) {
        Intent in = new Intent(this,Profile.class);
        startActivity(in);
    }
}