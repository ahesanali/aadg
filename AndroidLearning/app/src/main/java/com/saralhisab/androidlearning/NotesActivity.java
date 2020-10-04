package com.saralhisab.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        //setup database
        dbHelper = new DBHelper(this);
        getNotesFromDB();
        //Initialize button in activity and call addNote() method in click listener of that button
    }

    private void addNote() {
        int note_id = (int) dbHelper.insertNote("Hello","I am description");
        if(note_id != -1)
            Toast.makeText(this,"Note created",Toast.LENGTH_SHORT).show();
    }

    private void getNotesFromDB()
    {
        noteList = new ArrayList<>();
        noteList = this.dbHelper.getNotes();
        Toast.makeText(this,"Note List"+noteList.size(),Toast.LENGTH_SHORT).show();
    }
}
