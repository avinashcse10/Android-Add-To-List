package com.example.homework14;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ThirdActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //String i = getIntent().getStringExtra("position");
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String Name = bundle.getString("textName");
        String Mail = bundle.getString("textMail");

        TextView textName = findViewById(R.id.listViewName);
        TextView textMail = findViewById(R.id.listViewMail);

        textName.setText("Name:: "+Name);
        textMail.setText("Email ID::  "+Mail);

        //Toast.makeText(this,Number,Toast.LENGTH_SHORT).show();
    }
    public void ListViewBack(View view){
        finish();
    }
}