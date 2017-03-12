package com.example.rookie.weather;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences.Editor editor= PreferenceManager.getDefaultSharedPreferences(Main2Activity.this).edit();
        editor.putString("flag",null);
        editor.apply();
    }
}
