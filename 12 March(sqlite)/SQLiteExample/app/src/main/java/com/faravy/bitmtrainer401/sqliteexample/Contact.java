package com.faravy.bitmtrainer401.sqliteexample;

/**
 * Created by BITM Trainer 401 on 3/12/2016.
 */
public class Contact {

    private  int id;
    private String name;
    private String phoneNo;

    public Contact(int id, String name, String phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public Contact(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
