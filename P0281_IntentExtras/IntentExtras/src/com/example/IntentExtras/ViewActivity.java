package com.example.IntentExtras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Anton on 20/07/14.
 */
public class ViewActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");

        textView.setText("Your name is " + fname + " " + lname);
    }
}
