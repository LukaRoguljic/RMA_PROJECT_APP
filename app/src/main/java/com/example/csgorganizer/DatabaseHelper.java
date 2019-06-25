package com.example.csgorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "RMA.db";
    public static final String TABLE_NAME = "practices";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MAPS";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "COMMENT";
    public static final String COL_5 = "OPPONENT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, MAPS TEXT, DATE TEXT, COMMENT TEXT, OPPONENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String maps, String date, String comment, String opponent){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, maps);
        contentValues.put(COL_3, date);
        contentValues.put(COL_4, comment);
        contentValues.put(COL_5, opponent);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        }
        else
            return true;
    }

}
