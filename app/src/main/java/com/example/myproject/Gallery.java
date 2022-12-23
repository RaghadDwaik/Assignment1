package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ImageView v = findViewById(R.id.image);
        AnimationDrawable u = (AnimationDrawable) v.getDrawable();
        u.start();


    }



}