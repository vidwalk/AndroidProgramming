package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets.db";
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetsContract.PetEntry.TABLE_NAME + "("
                + PetsContract.PetEntry.ID + "INTEGER PRIMARY KEY INCREMENT,"
                + PetsContract.PetEntry.COLUMN_PET_NAME + "TEXT,"
                + PetsContract.PetEntry.COLUMN_PET_BREED + "TEXT,"
                + PetsContract.PetEntry.COLUMN_PET_GENDER + "INTEGER NOT NULL,"
                + PetsContract.PetEntry.COLUMN_PET_WEIGHT + "INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il){

    }
}
