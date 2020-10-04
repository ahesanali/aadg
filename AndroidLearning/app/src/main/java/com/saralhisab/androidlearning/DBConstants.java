package com.saralhisab.androidlearning;

/**
 * Created by ahesan on 28/03/18.
 */

public class DBConstants {
    public final static String DATABASE_NAME = "notes_db.sqlite";

    public static final int DATABASE_VERSION = 1;

    // Tables Name
    public static final String TABLE_NOTES = "tblNotes";

    // tblEstimations Table columns
    public static final String COLUMN_NOTE_ID = "_id";
    public static final String COLUMN_NOTE_TITLE = "note_title";
    public static final String COLUMN_NOTE_DESCRIPTION = "note_description";

    // create table statement estimation
    public static final String CREATE_TBL_NOTES = "create table "
            + DBConstants.TABLE_NOTES + " (" + DBConstants.COLUMN_NOTE_ID
            + " integer primary key autoincrement, "
            + DBConstants.COLUMN_NOTE_TITLE + " text not null, "
            + DBConstants.COLUMN_NOTE_DESCRIPTION + " text  null)";

}
