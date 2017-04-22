package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.ShelterContract.PetsEntry;

/**
 * Create,open, upgrade or delete the shelter database.
 */
public class PetDbHelper extends SQLiteOpenHelper {
    // File name of the database
    public static final String DATABASE_NAME = "shelter.db";
    // Database version number. If you change the database schema you must increment this number.
    public static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL command to create the table
        String SQL_CREATE_PETS_TABLE =
                "CREATE TABLE pets (" +
                        PetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PetsEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                        PetsEntry.COLUMN_PET_BREED + " TEXT, " +
                        PetsEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                        PetsEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
