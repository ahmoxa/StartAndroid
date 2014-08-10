package com.example.SimpleCursorAdapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anton on 10.08.2014.
 */
public class DB {
    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "mytab";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_TXT = "txt";

    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
            COLUMN_ID + " integer primary key autoincrement, "+
            COLUMN_IMG + " integer, " +
            COLUMN_TXT + " text" +
            ");";

    private final Context context;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DB(Context context){
        this.context = context;
    }

    public void open(){
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        if (dbHelper != null){
            dbHelper.close();
        }
    }

    public Cursor getAllData(){
        return db.query(DB_TABLE, null, null, null, null, null, null);
    }

    public void addRec(String txt, int img){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TXT, txt);
        cv.put(COLUMN_IMG, img);
        db.insert(DB_TABLE, null, cv);
    }

    public void delRec(long id){
        db.delete(DB_TABLE, COLUMN_ID + " = " + id, null);
    }



    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DB_CREATE);

            ContentValues cv = new ContentValues();
            for (int i = 0; i < 5; i ++) {
                cv.put(COLUMN_TXT, "sometext " + i);
                cv.put(COLUMN_IMG, R.drawable.ic_launcher);
                sqLiteDatabase.insert(DB_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }
}
