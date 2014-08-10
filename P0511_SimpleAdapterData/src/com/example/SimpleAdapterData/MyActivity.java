package com.example.SimpleAdapterData;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {

    private static final int CM_DELETE_ID = 1;

    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;
    SimpleAdapter simpleAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> m;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        data = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "sometext " + i);
            m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.ivImg};

        simpleAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        lvSimple = (ListView)findViewById(R.id.lvSimple);
        lvSimple.setAdapter(simpleAdapter);
        registerForContextMenu(lvSimple);
    }

    public void onButtonClick(View v) {
        m = new HashMap<String, Object>();
        m.put(ATTRIBUTE_NAME_TEXT, "sometext " + (data.size() + 1));
        m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ic_launcher);
        data.add(m);
        simpleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Удалить запись");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            data.remove(acmi.position);
            simpleAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
