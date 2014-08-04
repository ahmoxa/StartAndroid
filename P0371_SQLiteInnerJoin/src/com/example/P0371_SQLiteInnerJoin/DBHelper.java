package com.example.P0371_SQLiteInnerJoin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 class DBHelper extends SQLiteOpenHelper {

    final static String LOG_TAG = "myLogs";

    int[] position_id = { 1, 2, 3, 4 };
    String[] position_name = { "Директор", "Программер", "Бухгалтер", "Охранник" };
    int[] position_salary = { 15000, 13000, 10000, 8000 };

    String[] people_name = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь" };
    int[] people_posid = { 2, 3, 2, 2, 3, 1, 2, 4 };

    public DBHelper(Context context){
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(LOG_TAG, "--- onCreate database ---");

        ContentValues cv = new ContentValues();

        sqLiteDatabase.execSQL("create table position ("
                               + " id integer primary key,"
                               + "name text,"
                               + "salary integer"
                               + ")");
        for (int i = 0; i < position_id.length; i++){
            cv.put("id", position_id[i]);
            cv.put("name", position_name[i]);
            cv.put("salary", position_salary[i]);
            sqLiteDatabase.insert("position", null, cv);
        }

        sqLiteDatabase.execSQL("create table people (id integer primary key autoincrement, name text, posid integer);");
        for(int i = 0; i < people_name.length; i++) {
            cv.clear();
            cv.put("name", people_name[i]);
            cv.put("posid", people_posid[i]);
            sqLiteDatabase.insert("people", null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
