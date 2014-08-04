package com.example.P0381_SQLiteTransaction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vlasyk on 04.08.14.
 */
public class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context context){
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(MainActivity.LOG_TAG, "--- onCreate database ---");

        sqLiteDatabase.execSQL("create table mytable ("
                                + "id integer primary key autoincrement,"
                                + "val text"
                                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
