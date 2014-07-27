package com.example.P0331_SharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity implements View.OnClickListener{

    EditText etText;
    Button btnSave;
    Button btnLoad;
    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etText = (EditText)findViewById(R.id.etText);
        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        loadText();
    }

    @Override
    protected void onDestroy() {
        saveText();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnSave:
                saveText();
                break;
        }
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
