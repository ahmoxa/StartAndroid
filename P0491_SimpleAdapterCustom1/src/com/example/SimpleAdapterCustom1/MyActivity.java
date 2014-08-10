package com.example.SimpleAdapterCustom1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {

    //имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_VALUE = "value";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    //картинки для отображения динамики
    final  static int positive = android.R.drawable.arrow_up_float;
    final static int negative = android.R.drawable.arrow_down_float;

    ListView lvSimple;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //массив данных
        int[] values = {8, 4, -3, 2, -5, 0, 3, -6, 1, -1 };

        //упаковка данных для адаптера
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(values.length);
        Map<String, Object> m;
        int img = 0;
        for(int i = 0; i < values.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Day " + (i + 1));
            m.put(ATTRIBUTE_NAME_VALUE, values[i]);
            if (values[i] == 0) img = 0;
            else img = (values[i] > 0) ? positive : negative;
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.tvValue, R.id.ivImg};

        MySimpleAdapter simpleAdapter = new MySimpleAdapter(this, data, R.layout.item, from, to);
        lvSimple = (ListView)findViewById(R.id.lvSimple);
        lvSimple.setAdapter(simpleAdapter);


    }
}
