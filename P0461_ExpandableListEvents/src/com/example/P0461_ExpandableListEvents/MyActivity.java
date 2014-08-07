package com.example.P0461_ExpandableListEvents;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class MyActivity extends Activity {

    final String LOG_TAG = "myLogs";
    ExpandableListView elvMain;
    AdapterHelper adapterHelper;
    SimpleExpandableListAdapter adapter;
    TextView tvInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvInfo = (TextView)findViewById(R.id.tvInfo);
        adapterHelper = new AdapterHelper(this);
        adapter = adapterHelper.getAdapter();

        elvMain = (ExpandableListView)findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);


        elvMain.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPos, int childPos, long id) {
                Log.d(LOG_TAG, "onChildClick groupPosition = " + groupPos + " ChildPosition = " + childPos + " id = " + id);
                tvInfo.setText(adapterHelper.getGroupChildText(groupPos, childPos));
                return false;
            }
        });

        elvMain.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Log.d(LOG_TAG, "onGroupClick groupPosition = " + i + " id = " + l);
                if (i == 1) return true;
                return false;
            }
        });

        elvMain.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                Log.d(LOG_TAG, "onGroupCollapse groupPosition = " + i);
                tvInfo.setText("Свернули " + adapterHelper.getGroupText(i));
            }
        });

        elvMain.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Log.d(LOG_TAG, "onGroupExpand groupPosition = " + i);
                tvInfo.setText("Развернули " + adapterHelper.getGroupText(i));
            }
        });

        elvMain.expandGroup(2);
    }
}
