package com.example.P0391_SQLiteOnUpgradeDB;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {



    final static String DB_NAME = "staff";
    final static int DB_VERSION = 2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        Helper.log("--- Staff db v." + db.getVersion() + " ---");;
        writeStaff(db);
        dbh.close();
    }

    private void writeStaff(SQLiteDatabase db){
        Cursor c = db.rawQuery("select * from people", null);
        logCursor(c, "Table people");

        c = db.rawQuery("select * from position", null);
        logCursor(c, "Table position");

        String sqlQuery = "select PL.name as Name, PS.name as Postion, salary as Salary "
                + "from people as PL "
                + "inner join position as PS "
                + "on PL.posid = PS.id ";
        c = db.rawQuery(sqlQuery, null);
        logCursor(c, "inner join");
    }

    void logCursor(Cursor c, String title){
        if ( c!= null ){
            if ( c.moveToFirst() ) {
                Helper.log(title + ". " + c.getCount() + " rows");
                StringBuilder sb = new StringBuilder();
                do{
                    sb.setLength(0);
                    for (String cn : c.getColumnNames()) {
                        sb.append(( cn +  " = " + c.getString(c.getColumnIndex(cn)) + "; "));
                    }
                    Helper.log(sb.toString());
                }while (c.moveToNext());
            }
        } else {
            Helper.log(title + ". Cursor is null");
        }
    }



}
