package com.faravy.bitmtrainer401.noteprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class NoteOperation {
    NoteHelper helper;
    SQLiteDatabase db;

    public NoteOperation(Context context) {
        helper = new NoteHelper(context);
    }

    public void open() {
        db = helper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public boolean addNote(String note) {
        ContentValues values = new ContentValues();
        values.put(NoteHelper.COL_NOTE, note);
        long id = db.insert(NoteHelper.TABLE_NAME, null, values);
        return id != -1;
    }

    public Cursor notes() {
        return db.query(NoteHelper.TABLE_NAME, null, null, null, null, null, null);
    }





}






