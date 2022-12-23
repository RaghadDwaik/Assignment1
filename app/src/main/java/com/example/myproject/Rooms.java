package com.example.myproject;

public class Rooms {
    private String name;
    private int imageID;

    public static final Rooms[] Room = {
            new Rooms("room1", R.drawable.room1),
            new Rooms("room1", R.drawable.room2),
            new Rooms("room1", R.drawable.room3),
            new Rooms("room1", R.drawable.room4),
            new Rooms("room1", R.drawable.room5)

    };
    private Rooms(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}

}

