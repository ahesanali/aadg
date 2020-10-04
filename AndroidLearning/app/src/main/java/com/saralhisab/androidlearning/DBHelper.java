package com.saralhisab.androidlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ahesan on 28/03/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    public DBHelper(final Context context) {
        super(context, DBConstants.DATABASE_NAME, null,
                DBConstants.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBConstants.CREATE_TBL_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //NOTE:: thid method will be usefull when are updating the app with database level changes
    }

    private void openDb()
    {
        this.db = this.getWritableDatabase();
    }
    private void closeDb()
    {
        this.db.close();
        this.close();
    }

    public long insertNote(String noteTitle, String noteDescription)
    {
        final ContentValues initialValues = new ContentValues();
        initialValues.put(DBConstants.COLUMN_NOTE_TITLE, noteTitle);
        initialValues.put(DBConstants.COLUMN_NOTE_DESCRIPTION, noteDescription);
        //open database
        this.openDb();
        //execute query
        final long lRowId = this.db.insert(DBConstants.TABLE_NOTES, null,
                initialValues);
        initialValues.clear();
        //close database
        this.closeDb();
        return lRowId;
    }

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();
         Cursor mCursor = null;
        Note note;
        try {
            this.openDb();
            mCursor = db.query(true,
                    DBConstants.TABLE_NOTES, null, null, null, null,null, DBConstants.COLUMN_NOTE_ID + " DESC", null);
            if (mCursor != null) {
                mCursor.moveToFirst();
                while (!mCursor.isAfterLast()) {

                    note = new Note();

                    note
                            .setId(mCursor.getInt(mCursor
                                    .getColumnIndexOrThrow(DBConstants.COLUMN_NOTE_ID)));
                    note.setTitle(mCursor.getString(mCursor
                            .getColumnIndexOrThrow(DBConstants.COLUMN_NOTE_TITLE)));

                    note.setDescription(mCursor.getString(mCursor
                            .getColumnIndexOrThrow(DBConstants.COLUMN_NOTE_DESCRIPTION)));

                    // Add the object to list
                    notes.add(note);
                    // Iterate to the next row of the cursor
                    mCursor.moveToNext();

                }
            }
        } finally {
            this.closeDb();
            if ((mCursor != null) && !mCursor.isClosed()) {
                mCursor.close();
            }
        }
        return notes;
    }
}
