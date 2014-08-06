package com.example.P0451_ExpandableList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {

    // названия компаний (групп)
    String[] groups = new String[] {"HTC", "Samsung", "LG"};

    // названия телефонов (элементов)
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};

    ArrayList<Map<String,String>> groupData;
    ArrayList<Map<String, String>> childDataitem;
    ArrayList<ArrayList<Map<String, String>>> childData;

    Map<String, String> m;

    ExpandableListView elvMain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        groupData = new ArrayList<Map<String, String>>();
        for(String group : groups){
            m = new HashMap<String, String>();
            m.put("groupName", group);
            groupData.add(m);
        }

        String groupFrom[] = new String[] {"groupName"};
        int groupTo[] = new int[] {android.R.id.text1};


        childData = new ArrayList<ArrayList<Map<String, String>>>();
        childDataitem = new ArrayList<Map<String, String>>();
        for(String phone : phonesHTC) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataitem.add(m);
        }
        childData.add(childDataitem);

        childDataitem = new ArrayList<Map<String, String>>();
        for (String phone : phonesSams) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataitem.add(m);
        }
        childData.add(childDataitem);

        childDataitem = new ArrayList<Map<String, String>>();
        for(String phone : phonesLG){
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataitem.add(m);
        }
        childData.add(childDataitem);

        String[] childFrom = new String[] {"phoneName"};
        int childTo[] = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo
        );

        elvMain = (ExpandableListView)findViewById(R.id.elvmain);
        elvMain.setAdapter(adapter);
    }
}
