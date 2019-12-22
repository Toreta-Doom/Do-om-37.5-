package com.toreta.do_om;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.toreta.do_om.activity.MainActivity;

import java.util.ArrayList;

public class FundingActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;
    private TextView vo;
    private EditText editText;
    private Button ok_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding);

        init();

        spinnerListener();

        buttonListener();

//        keyListener();
    }

    private void buttonListener() {
        ok_btn.setOnClickListener(view -> {
            Toast.makeText(this, "등록 성공", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void keyListener() {
        editText.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                new Handler().postDelayed(() -> ok_btn.setVisibility(View.GONE), 500);

            }
        });


    }

    private void spinnerListener() {

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                vo.setText(arrayList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void init() {

        arrayList = new ArrayList<>();

        arrayList.add("자금");
        arrayList.add("봉사");
        arrayList.add("재능");


        spinner = findViewById(R.id.spinner);
        vo = findViewById(R.id.vo);
        editText = findViewById(R.id.funding_edit);
        ok_btn = findViewById(R.id.funding_OK);
    }
}
