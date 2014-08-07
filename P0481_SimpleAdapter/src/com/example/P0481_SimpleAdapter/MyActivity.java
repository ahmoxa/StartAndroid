package com.example.P0481_SimpleAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {

    final String ATTR_NAME_TEXT = "text";
    final String ATTR_NAME_CHECKED = "checked";
    final String ATTR_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] texts = { "sometext 1", "sometext 2", "sometext 3", "sometext 4", "sometext 5" };
        boolean[] checked = { true, false, false, true, false };
        int img = R.drawable.ic_launcher;

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
        Map<String, Object> m;

        for(int i = 0; i < texts.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTR_NAME_TEXT, texts[i]);
            m.put(ATTR_NAME_CHECKED, checked[i]);
            m.put(ATTR_NAME_IMAGE, img);
            data.add(m);
        }

        String[] from = {ATTR_NAME_TEXT, ATTR_NAME_CHECKED, ATTR_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item,from, to);
        lvSimple = (ListView)findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);
    }
}
