package ru.startandroid.SimpleSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anton on 26/07/14.
 */
public class DBHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "myLogs";

    public DBHelper(Context context){
        super(context, "MyDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");

        db.execSQL("create table mytable ("
                + "id integer primary key autoincrement,"
                + "name text,"
                + "email text" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
