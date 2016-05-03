package com.faravy.bitmtrainer401.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by BITM Trainer 401 on 3/12/2016.
 */
public class Contact_Manager {
    private DatabaseHelper helper;
    private Contact contact;
    private SQLiteDatabase database;

    public Contact_Manager(Context context) {
        helper = new DatabaseHelper(context);
    }

    private void open() {
        database = helper.getWritableDatabase();
    }

    private void close() {
        helper.close();
    }

    public boolean addContact(Contact contact) {
        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.COL_NAME, contact.getName());
        contentValues.put(DatabaseHelper.COL_PHONENO, contact.getPhoneNo());

        long inserted = database.insert(DatabaseHelper.TABLE_CONTACT, null, contentValues);
        database.close();
        this.close();

        if (inserted > 0) {
            return true;

        } else return false;

    }

    public Contact getContact(int id) {

        this.open();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CONTACT, new String[]{DatabaseHelper.COL_ID, DatabaseHelper.COL_NAME, DatabaseHelper.COL_PHONENO}, DatabaseHelper.COL_ID + " = " + id, null, null, null, null);

        cursor.moveToFirst();

        int mId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
        String phoneNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONENO));

        contact = new Contact(mId, name, phoneNo);
        this.close();
        return contact;


    }

    public ArrayList<Contact> getAllContacts() {

        this.open();
        ArrayList<Contact> contactList = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_CONTACT, null, null, null, null, null, null);

        cursor.moveToFirst();

        if (cursor != null && cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {

                int mId = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONENO));
                contact = new Contact(mId, name, phoneNo);

                contactList.add(contact);
                cursor.moveToNext();
            }

        }
        this.close();
        return contactList;
    }

    public boolean deleteContact(int id) {
        this.open();
        int deleted = database.delete(DatabaseHelper.TABLE_CONTACT, DatabaseHelper.COL_ID + "= " + id, null);
        this.close();
        if (deleted > 0) {
            return true;
        } else return false;

    }

    public boolean updateContact(int id, Contact contact) {
        this.open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME, contact.getName());
        contentValues.put(DatabaseHelper.COL_PHONENO, contact.getPhoneNo());

        int updated = database.update(DatabaseHelper.TABLE_CONTACT, contentValues, DatabaseHelper.COL_ID + " = " + id, null);
        this.close();
        if (updated > 0) {
            return true;
        } else return false;

    }
}
