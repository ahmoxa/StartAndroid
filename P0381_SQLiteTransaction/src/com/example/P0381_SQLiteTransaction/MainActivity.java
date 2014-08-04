package com.example.P0381_SQLiteTransaction;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    final static String LOG_TAG = "myLogs";
    DBHelper dbh;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.d(LOG_TAG, "---onCreate Activity ---");
        dbh = new DBHelper(this);
        myActions();
    }

    void myActions(){
        try {
            db = dbh.getWritableDatabase();
            delete(db, "mytable");

            db.beginTransaction();

            insert(db, "mytable", "val1");
            Log.d(LOG_TAG, "Create DBHelper");
            DBHelper dbh2 = new DBHelper(this);
            Log.d(LOG_TAG, "get db");
            SQLiteDatabase db2 = dbh2.getWritableDatabase();
            read(db2, "mytable");
            dbh2.close();

            db.setTransactionSuccessful();
            db.endTransaction();


            read(db, "mytable");
            dbh.close();
        }catch (Exception ex){
            Log.d(LOG_TAG, ex.getClass() + " error: " + ex.getMessage());
        }

    }

    void delete(SQLiteDatabase db, String table){
        Log.d(LOG_TAG, "Delete all from table " + table);
        db.delete(table, null, null);
    }

    void insert(SQLiteDatabase db, String table, String value){
        Log.d(LOG_TAG, "Insert in table " + table + " value " + value);
        ContentValues cv = new ContentValues();
        cv.put("val", value);
        db.insert(table, null, cv);
    }

    void read(SQLiteDatabase db, String table){
        Log.d(LOG_TAG, "Read table " + table);
        Cursor c = db.query(table, null, null, null, null, null, null);
        if (c != null) {
            Log.d(LOG_TAG, "Record count = " + c.getCount());
            if (c.moveToFirst() ){
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")));
                }while (c.moveToNext());
            }
        }
    }
}
