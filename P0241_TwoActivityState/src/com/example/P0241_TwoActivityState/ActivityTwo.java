package com.example.P0241_TwoActivityState;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class ActivityTwo extends Activity {

    final static String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        Log.d(TAG, "Activity Two onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Activity Two onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "Activity Two onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "Activity Two onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "Activity Two onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "Activity Two onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Activity Two onDestroy");
    }
}
