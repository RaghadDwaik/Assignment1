package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.net.IDN;


public class Room extends AppCompatActivity implements Recycler{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        RecyclerView recycler = findViewById(R.id.room_recycler);

        String[] captions = new String[Rooms.Room.length];
        int[] ids = new int[Rooms.Room.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = Rooms.Room[i].getName();
            ids[i] = Rooms.Room[i].getImageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(captions, ids,this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent in = new Intent(this,eachRoom.class);
        in.putExtra("raghad",
                position);
        startActivity(in);


    }

    public void roomAdd(View view) {
        Intent in = new Intent(this,addRoom.class);
        startActivity(in);
    }
}


