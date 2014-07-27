package com.example.P0241_TwoActivityState;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {

    final static String TAG = "States";
    Button btnActTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnActTwo = (Button) findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(this);

        Log.d(TAG, "Activity One onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Activity One onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "Activity One onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "Activity One onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "Activity One onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "Activity One onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "Activity One onDestroy");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }
}
