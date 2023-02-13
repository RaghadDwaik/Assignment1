package com.example.myproject;

import java.util.ArrayList;

public class Rooms {

    private String name;
    private String image;

    @Override
    public String toString() {
        return "name"+name + "image"+image;
    }

    ArrayList<Rooms> rr;

    public Rooms(){

    }
    public Rooms(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}




