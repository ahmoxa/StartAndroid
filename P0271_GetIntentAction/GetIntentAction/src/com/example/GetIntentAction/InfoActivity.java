package com.example.GetIntentAction;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoActivity extends Activity{

    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        tvInfo = (TextView) findViewById(R.id.tvInfo);

        Intent intent = getIntent();
        String action = intent.getAction();

        String format = "", textInfo = "";

        if (action.equals("ru.startandroid.intent.action.showtime")){
            format = "HH:mm:ss";
            textInfo = "Time:";
        } else if (action.equals("ru.startandroid.intent.action.showdate")){
            format = "dd.MM.yyyy";
            textInfo = "Date:";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String datetime = sdf.format(new Date(System.currentTimeMillis()));

        tvInfo.setText(textInfo + datetime);

    }
}
