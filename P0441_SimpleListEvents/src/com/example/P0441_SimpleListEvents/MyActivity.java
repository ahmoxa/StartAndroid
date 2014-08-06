package com.example.P0441_SimpleListEvents;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity {

    final static String LOG_TAG = "myLogs";

    ListView lvMain;
    TextView tvText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lvMain = (ListView)findViewById(R.id.lvMain);
        tvText = (TextView)findViewById(R.id.tvText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_1);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG, "itemSelect: position = " + i + ", id = " + l);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(LOG_TAG, "itemSelect: nothing");
            }
        });

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG, "itemClick: position = " + i + ", id = " + l);
            }
        });

        lvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                Log.d(LOG_TAG, "scroll: firstVisibleItem = " + i + ", visibleItemCount" + i2 + ", totalItemCount" + i3);
            }
        });
    }
}
