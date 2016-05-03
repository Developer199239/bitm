package com.faravy.bitmtrainer401.noteprovidertester;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadAllNotesFromProvider();
    }

    private void loadAllNotesFromProvider() {
        Uri uri = Uri.parse("content://com.faravy.bitmtrainer401.noteprovider.contentprovider/notes");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] {"note"},
                new int[] {android.R.id.text1});
        ((ListView) findViewById(R.id.lvNotes)).setAdapter(adapter);
    }
}
