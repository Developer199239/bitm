package com.example.murtuza.listview;

/**
 * Created by Murtuza on 3/5/2016.
 */
public class Person {
    private  String name;
    private String phone;
    private int image;

    public Person(String name, String phone, int image) {
        setName(name);
        setPhone(phone);
        setImage(image);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
