package com.faravy.bitmtrainer401.noteprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.lvNotes) ListView lvNotes;
    @Bind(R.id.etNote) EditText etNote;

    NoteOperation noteOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        noteOperation = new NoteOperation(this);
    }

    @Override
    protected void onResume() {
        noteOperation.open();
        //loadAllNotesFromDB();
        loadAllNotesFromProvider();
        super.onResume();
    }

    @Override
    protected void onPause() {
        noteOperation.close();
        super.onPause();
    }

    @OnClick(R.id.btnAdd)
    public void addNote() {
        String note = etNote.getText().toString();
        if(noteOperation.addNote(note)) {
            Toast.makeText(MainActivity.this,
                    "Successfully added", Toast.LENGTH_LONG).show();
        }

        //loadAllNotesFromDB();
        loadAllNotesFromProvider();
    }

    private void loadAllNotesFromDB() {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                noteOperation.notes(),
                new String[] {NoteHelper.COL_NOTE},
                new int[] {android.R.id.text1});
        lvNotes.setAdapter(adapter);
    }

    private void loadAllNotesFromProvider() {
        Uri uri = Uri.parse("content://" + NoteProvider.AUTHORITY + "/notes");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] {NoteHelper.COL_NOTE},
                new int[] {android.R.id.text1});
        lvNotes.setAdapter(adapter);
    }
}
