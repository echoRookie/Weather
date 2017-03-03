package com.example.rookie.weather.db;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.rookie.weather.R;

import static com.example.rookie.weather.R.id.toolbar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView=(TextView) findViewById(R.id.textView2);
        String qqq=getIntent().getStringExtra("1");
        textView.setText(qqq);

    }

}
