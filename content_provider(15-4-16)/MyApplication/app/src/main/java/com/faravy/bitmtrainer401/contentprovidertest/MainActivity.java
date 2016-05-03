package com.faravy.bitmtrainer401.contentprovidertest;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContacts = (ListView) findViewById(R.id.lvContacts);

        String[] projection = new String[] {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID
        };

        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                projection, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.contact_item, cursor, projection, new int[] {R.id.tvName, R.id.tvId});

        lvContacts.setAdapter(adapter);

        if (cursor != null && cursor.moveToFirst()) {
            StringBuilder builder = new StringBuilder();
            do {
                builder.append(cursor.getInt(cursor.getColumnIndex(projection[1])));
                builder.append(" : ");
                builder.append(cursor.getString(
                                cursor.getColumnIndex(projection[0])));
                builder.append("\n");
            } while (cursor.moveToNext());

            ((TextView) findViewById(R.id.tvRes)).setText(builder.toString());
        }
    }
}
