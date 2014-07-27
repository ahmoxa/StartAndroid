package com.example.P0181_DynamicLayout3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MyActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbWeight;
    Button btn1, btn2;

    LinearLayout.LayoutParams lParams1, lParams2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        lParams1 = (LinearLayout.LayoutParams)btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams)btn2.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int leftValue = i;
        int rightValue = seekBar.getMax() - leftValue;

        lParams1.weight = leftValue;
        lParams2.weight = rightValue;
        btn1.requestLayout();
        btn2.requestLayout();

//        btn1.setText(String.valueOf(leftValue));
//        btn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
