package com.example.myproject;

public class Rooms {
    private int id;
    private double price;
    private String title;
    private int floor;
    private int beds;
    private String description;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




    public Rooms(int id, double price, String title, int floor, int beds, String description, String image) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.floor = floor;
        this.beds = beds;
        this.description = description;
        this.image = image;
    }
}




