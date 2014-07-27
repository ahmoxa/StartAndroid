package com.example.P0161_DynamicLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.ViewGroup.*;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);

        LinearLayout linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutParams linLayoutParams= new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;

        LinearLayout.LayoutParams rightGraviteParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rightGraviteParams.gravity = Gravity.RIGHT;


        TextView tv = new TextView(this);
        tv.setText("TextView");
        tv.setLayoutParams(lpView);

        Button btn = new Button(this);
        btn.setText("Button");

        Button btn1 = new Button(this);
        btn1.setText("Button1");

        Button btn2 = new Button(this);
        btn2.setText("Button2");

        linLayout.addView(tv);
        linLayout.addView(btn, lpView);
        linLayout.addView(btn1, leftMarginParams);
        linLayout.addView(btn2,rightGraviteParams);


        setContentView(linLayout, linLayoutParams);
    }
}
