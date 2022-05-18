package com.example.classwork.models;

import java.io.Serializable;

public class Consult implements Serializable {
    private String name;
    private String room;
    private int imageVIew;

    public Consult(String name, String room, int imageVIew){
        this.name =name;
        this.room = room;
        this.imageVIew = imageVIew;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getImageVIew() {
        return imageVIew;
    }

    public void setImageVIew(int imageVIew) {
        this.imageVIew = imageVIew;
    }


}