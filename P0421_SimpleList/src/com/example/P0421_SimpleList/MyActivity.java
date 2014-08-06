package com.example.P0421_SimpleList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyActivity extends Activity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_list_item, names);
        lvMain.setAdapter(adapter);
    }
}
