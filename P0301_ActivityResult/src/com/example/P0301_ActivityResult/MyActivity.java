package com.example.P0301_ActivityResult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MyActivity extends Activity implements OnClickListener{

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvText = (TextView)findViewById(R.id.tvText);
        btnColor = (Button)findViewById(R.id.btnColor);
        btnAlign = (Button)findViewById(R.id.btnAlign);

        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color", Color.WHITE);
                    tvText.setTextColor(color);
                    break;
                case REQUEST_CODE_ALIGN:
                    int align = data.getIntExtra("aligment", Gravity.LEFT);
                    tvText.setGravity(align);
                    break;
            }
        }else {
            Toast.makeText(this, "Wrong Result", Toast.LENGTH_LONG).show();
        }
    }
}
