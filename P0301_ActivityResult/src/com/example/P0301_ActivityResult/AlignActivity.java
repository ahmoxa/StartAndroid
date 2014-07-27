package com.example.P0301_ActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class AlignActivity extends Activity implements OnClickListener {

    Button btnLeft;
    Button btnCenter;
    Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.align);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnCenter = (Button)findViewById(R.id.btnCenter);
        btnRight = (Button) findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        switch (view.getId()) {
            case R.id.btnLeft:
                intent.putExtra("aligment", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("aligment", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("aligment", Gravity.RIGHT);
                break;
        }

        setResult(RESULT_OK, intent);
        finish();

    }
}
