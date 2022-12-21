package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Room extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        RecyclerView recycler = findViewById(R.id.room_recycler);
        int[] Number = new int[Data.room.length];

        int[] ids = new int[Data.room.length];

        for(int i = 0; i<Number.length;i++){

            Number[i] = Data.room[i].getNumber();
            ids[i] = Data.room[i].getImageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter adapter = new CardAdapter(Number, ids);
        recycler.setAdapter(adapter);
    }
}