package com.example.P0391_SQLiteOnUpgradeDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vlasyk on 04.08.14.
 */
public class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context context){
        super(context, MainActivity.DB_NAME, null, MainActivity.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Helper.log("-- onCreate database ---");
        String[] people_name = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь" };
        int[] people_posid = { 2, 3, 2, 2, 3, 1, 2, 4 };

        int[] position_id = {1,2,3,4};
        String[] position_name = { "Директор", "Программер", "Бухгалтер", "Охранник"};
        int[] position_salary = {15000, 13000, 10000, 8000};

        ContentValues cv = new ContentValues();

        sqLiteDatabase.execSQL("create table position (id integer primary key, name text, salary integer);");
        for (int i = 0; i < position_id.length; i++) {
            cv.clear();
            cv.put("id", position_id[i]);
            cv.put("name", position_name[i]);
            cv.put("salary", position_salary[i]);
            sqLiteDatabase.insert("position", null, cv);
        }






        sqLiteDatabase.execSQL("create table people ("
                                + "id integer primary key autoincrement,"
                                + "name text,"
                                + "posid integer);");
        for (int i = 0; i <people_name.length; i++){
            cv.clear();
            cv.put("name", people_name[i]);
            cv.put("posid", people_posid[i]);
            sqLiteDatabase.insert("people", null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Helper.log("--- onUpgrade database from " + oldVersion + " to " + newVersion + "version ---");
        if (oldVersion == 1 && newVersion == 2) {
            ContentValues cv = new ContentValues();
            int[] position_id = {1,2,3,4};
            String[] position_name = { "Директор", "Программер", "Бухгалтер", "Охранник" };
            int[] position_salary = {15000, 13000, 10000, 8000};

            sqLiteDatabase.beginTransaction();
            try{
                sqLiteDatabase.execSQL("create table position ("
                                + "id integer primary key,"
                                + "name text, salary integer);");
                for (int i = 0; i < position_id.length; i++) {
                    cv.clear();
                    cv.put("id", position_id[i]);
                    cv.put("name", position_name[i]);
                    cv.put("salary", position_salary[i]);
                    sqLiteDatabase.insert("position", null, cv);
                }

                sqLiteDatabase.execSQL("alter table people add column posid integer;");
                for(int i = 0; i < position_id.length; i ++){
                    cv.clear();
                    cv.put("posid", position_id[i]);
                    sqLiteDatabase.update("people", cv, "position = ?", new String[] {position_name[i]});
                }
                sqLiteDatabase.execSQL("create temporary table people_tmp ("
                                        + "id integer, name text, position text, posid integer);");
                sqLiteDatabase.execSQL("insert into people_tmp select id, name, position, posid from people");
                sqLiteDatabase.execSQL("drop table people;");
                sqLiteDatabase.execSQL("create table people ("
                                        + "id integer primary key autoincrement,"
                                        + "name text, posid integer);");
                sqLiteDatabase.execSQL("insert into people select id, name, posid from people_tmp;");
                sqLiteDatabase.execSQL("drop table people_tmp");

                sqLiteDatabase.setTransactionSuccessful();
            } finally {
                sqLiteDatabase.endTransaction();
            }

        }
    }
}
