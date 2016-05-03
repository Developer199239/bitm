package com.faravy.bitmtrainer401.noteprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BITM Trainer 401 on 4/15/2016.
 */
public class NoteHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "note.db";

    public static final String TABLE_NAME = "notes";
    public static final String COL_NOTE = "note";
    public static final String COL_ID = "_id";

    private static final String CREATE_QUERY = "create table "
            + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, "
            + COL_NOTE + " text)";

    public NoteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}