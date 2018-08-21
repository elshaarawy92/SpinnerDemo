package com.example.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> teamList;

    private TextView textView;

    private Spinner spinner1;

    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(teamList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void initView(){
        teamList = new ArrayList<>();
        initList();
        textView = findViewById(R.id.spinner_textview);
        spinner1 = findViewById(R.id.spinner1);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,teamList);
    }

    public void initList(){
        teamList.add("罗马");
        teamList.add("那不勒斯");
        teamList.add("国际米兰");
        teamList.add("AC米兰");
    }
}
