package com.example.user.dicodingvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextLength;
    EditText editTextWidth;
    EditText editTextHeight;
    TextView textViewResult;
    Button buttonCalculate;

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLength = (EditText) findViewById(R.id.et_length);
        editTextWidth = (EditText) findViewById(R.id.et_width);
        editTextHeight = (EditText) findViewById(R.id.et_height);
        textViewResult = (TextView) findViewById(R.id.tv_result);
        buttonCalculate = (Button) findViewById(R.id.btn_calculate);
        buttonCalculate.setOnClickListener(this);

        if(savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            textViewResult.setText(hasil);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, textViewResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_calculate){
            String length = editTextLength.getText().toString().trim();
            String width = editTextWidth.getText().toString().trim();
            String height = editTextHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if(TextUtils.isEmpty(length)){
                isEmptyFields = true;
                editTextLength.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(width)){
                isEmptyFields = true;
                editTextWidth.setError("Field ini tidak boleh kosong");
            }
            if(TextUtils.isEmpty(height)){
                isEmptyFields = true;
                editTextHeight.setError("Field ini tidak boleh kosong");
            }
            if(!isEmptyFields){
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l*w*h;
                textViewResult.setText(String.valueOf(volume));
            }
        }


    }
}
