package com.nazmul.bitmtrainer401.listviewwithcustomadapter;

/**
 * Created by BITM Trainer 401 on 3/5/2016.
 */
public class PersonModel {
    private String name;
    private String location;

    public PersonModel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public PersonModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
