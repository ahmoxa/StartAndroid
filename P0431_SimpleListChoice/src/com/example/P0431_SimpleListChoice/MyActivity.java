package com.example.P0431_SimpleListChoice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyActivity extends Activity implements View.OnClickListener {

    final static String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView)findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);

        Button btnChecked = (Button)findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View view) {
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for(int i = 0; i < sbArray.size(); i ++){
            int key = sbArray.keyAt(i);
            if (sbArray.get(key)){
                Log.d(LOG_TAG, names[key]);
            }
        }
    }
}
