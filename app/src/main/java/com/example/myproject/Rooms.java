package com.example.myproject;

public class Rooms {
    private String name;
    private static int imageID;

    public static final Rooms[] Room = {
            new Rooms("Room Number 1\n Price : 100$ \n Floor :1  " +  " \n click to book room",R.drawable.room1),
            new Rooms("Room Number 2\n Price : 70$ \n Floor :1  " +  " \n click to book room ", R.drawable.room2),
            new Rooms("Room Number 3\n Price : 80$ \n Floor :3  " +  " \n click to book room ", R.drawable.room3),
            new Rooms("Room Number 4\n Price : 50$ \n Floor :4  " +  " \n click to book room ", R.drawable.room4),
            new Rooms("Room Number 5 \n Price : 90$ \n Floor :7  " +  " \n click to book room ", R.drawable.room5)

    };
    private Rooms(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}

}

