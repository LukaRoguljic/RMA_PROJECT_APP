package com.example.csgorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "RMA.db";
    public static final String TABLE_NAME = "practices";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MAPS";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "COMMENT";
    public static final String COL_5 = "OPPONENT";
    public static final String COL_6 = "CREATED";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, MAPS TEXT, DATE TEXT, COMMENT TEXT, OPPONENT TEXT, CREATED INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String maps, String date, String comment, String opponent){
        SQLiteDatabase db = this.getWritableDatabase();
        long millis = System.currentTimeMillis();
        long seconds = millis/1000;
        long hours = seconds/3600;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, maps);
        contentValues.put(COL_3, date);
        contentValues.put(COL_4, comment);
        contentValues.put(COL_5, opponent);
        contentValues.put(COL_6, hours);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        }
        else
            return true;
    }

    public int deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        long millis = System.currentTimeMillis();
        long seconds = millis/1000;
        long hours = seconds/3600;

        /*String sql = "DELETE FROM " + TABLE_NAME + " WHERE (hours - CREATED) >= 24";
        db.execSQL(sql);*/
        return db.delete(TABLE_NAME, hours + " - " + COL_6 + " >= 0" , null);
    }

    public ArrayList<ListItem> getAllData(){
        ArrayList<ListItem> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM practices", null);

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String maps = cursor.getString(1);
            String date = cursor.getString(2);
            String comment = cursor.getString(3);
            String opponent = cursor.getString(4);

            ListItem listItem = new ListItem(id,maps,date,comment,opponent);

            arrayList.add(listItem);
        }
        return arrayList;
    }

}
