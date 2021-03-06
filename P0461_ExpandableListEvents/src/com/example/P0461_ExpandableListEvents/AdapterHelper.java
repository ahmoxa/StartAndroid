package com.example.P0461_ExpandableListEvents;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlasyk on 07.08.14.
 */
public class AdapterHelper {

    final String ATTR_GROUP_NAME = "groupName";
    final String ATTR_PHONE_NAME = "phoneName";
    String[] groups = new String[] {"HTC", "Samsung", "LG"};
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};

    ArrayList<Map<String, String>> groupData;
    ArrayList<Map<String, String>> childDataItem;
    ArrayList<ArrayList<Map<String, String>>> childData;
    Map<String, String> m;

    Context context;
    SimpleExpandableListAdapter adapter;

    AdapterHelper(Context context){
        this.context = context;
    }

    SimpleExpandableListAdapter getAdapter(){

        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            m = new HashMap<String, String>();
            m.put(ATTR_GROUP_NAME, group); // имя компании
            groupData.add(m);
        }
        String groupFrom[] = new String[] {ATTR_GROUP_NAME};
        int groupTo[] = new int[] {android.R.id.text1};
        childData = new ArrayList<ArrayList<Map<String, String>>>();
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : phonesHTC) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, phone); // название телефона
            childDataItem.add(m);
        }
        childData.add(childDataItem);
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : phonesSams) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : phonesLG) {
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);
        String childFrom[] = new String[] {ATTR_PHONE_NAME};
        int childTo[] = new int[] {android.R.id.text1};

        adapter = new SimpleExpandableListAdapter(
                context,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo
        );
        return  adapter;
    }

    public String getGroupText(int groupPos){
        return ((Map<String, String>) adapter.getGroup(groupPos)).get(ATTR_GROUP_NAME);
    }

    public String getChildText(int groupPos, int childPos){
        return ((Map<String, String>) adapter.getChild(groupPos, childPos)).get(ATTR_PHONE_NAME);
    }

    public String getGroupChildText(int groupPos, int childPos){
        return  getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }
}
