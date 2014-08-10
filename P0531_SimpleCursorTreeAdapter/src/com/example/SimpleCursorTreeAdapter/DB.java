package com.example.SimpleCursorTreeAdapter;

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

    private static final String COMPANY_TABLE = "company";
    public static final String COMPANY_COLUMN_ID = "_id";
    public static final String COMPANY_COLUMN_NAME = "name";
    private static final String COMPANY_TABLE_CREATE = "create table "
            + COMPANY_TABLE + "(" + COMPANY_COLUMN_ID
            + " integer primary key, " + COMPANY_COLUMN_NAME + " text" + ");";

    private static final String PHONE_TABLE = "phone";
    public static final String PHONE_COLUMN_ID = "_id";
    public static final String PHONE_COLUMN_NAME = "name";
    public static final String PHONE_COLUMN_COMPANY = "company";
    private static final String PHONE_TABLE_CREATE = "create table "
            + PHONE_TABLE + "(" + PHONE_COLUMN_ID
            + " integer primary key autoincrement, " + PHONE_COLUMN_NAME
            + " text, " + PHONE_COLUMN_COMPANY + " integer" + ");"; //"create table " + PHONE_TABLE + " (" + PHONE_COLUMN_ID + " integer primary key autoincrement, " + PHONE_COLUMN_NAME + "text, " + PHONE_COLUMN_COMPANY + " integer);";

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
        if (dbHelper != null) dbHelper.close();
    }

    public Cursor getCompanyData(){
        return db.query(COMPANY_TABLE, null, null, null, null, null, null);
    }

    public Cursor getPhoneData(long companyID){
        return db.query(PHONE_TABLE, null, PHONE_COLUMN_COMPANY + " = " + companyID, null, null, null, null);
    }


    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            ContentValues cv = new ContentValues();
            String[] companies = {"HTC", "Samsung","LG"};
            sqLiteDatabase.execSQL(COMPANY_TABLE_CREATE);
            for (int i = 0; i <companies.length; i++) {
                cv.put(COMPANY_COLUMN_ID, i +1);
                cv.put(COMPANY_COLUMN_NAME, companies[i]);
                sqLiteDatabase.insert(COMPANY_TABLE, null, cv);
            }

            String[] phonesHTC = new String[] { "Sensation", "Desire", "Wildfire", "Hero" };
            String[] phonesSams = new String[] { "Galaxy S II", "Galaxy Nexus", "Wave" };
            String[] phonesLG = new String[] { "Optimus", "Optimus Link", "Optimus Black", "Optimus One" };
            sqLiteDatabase.execSQL(PHONE_TABLE_CREATE);
            cv.clear();

            for (int i = 0; i < phonesHTC.length; i++){
                cv.put(PHONE_COLUMN_COMPANY, 1);
                cv.put(PHONE_COLUMN_NAME, phonesHTC[i]);
                sqLiteDatabase.insert(PHONE_TABLE, null, cv);
            }
            for (int i = 0; i < phonesSams.length; i++) {
                cv.put(PHONE_COLUMN_COMPANY, 2);
                cv.put(PHONE_COLUMN_NAME, phonesSams[i]);
                sqLiteDatabase.insert(PHONE_TABLE, null, cv);
            }
            for (int i = 0; i < phonesLG.length; i++) {
                cv.put(PHONE_COLUMN_COMPANY, 3);
                cv.put(PHONE_COLUMN_NAME, phonesLG[i]);
                sqLiteDatabase.insert(PHONE_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }

}
