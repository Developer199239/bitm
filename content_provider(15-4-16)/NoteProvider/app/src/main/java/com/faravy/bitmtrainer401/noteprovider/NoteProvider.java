package com.faravy.bitmtrainer401.noteprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by BITM Trainer 401 on 4/15/2016.
 */
public class NoteProvider extends ContentProvider {
    public static final String AUTHORITY = "com.faravy.bitmtrainer401.noteprovider.contentprovider";
    private static final int NOTES = 0;

    NoteHelper noteHelper;
    SQLiteDatabase db;

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY, "notes", NOTES);
        //uriMatcher.addURI(AUTHORITY, "notes/*", NOTES);
        //uriMatcher.addURI(AUTHORITY, "notes/#", NOTES);
    }

    @Override
    public boolean onCreate() {
        noteHelper = new NoteHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        switch (uriMatcher.match(uri)) {
            case 0:
                db = noteHelper.getWritableDatabase();
                return db.query(NoteHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            default:
                throw new UnsupportedOperationException("Uri didn't match");
        }

        // This code is not practical
        //String numericId =  uri.getLastPathSegment();
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
