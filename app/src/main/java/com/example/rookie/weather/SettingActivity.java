package com.example.rookie.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        this.getFragmentManager().beginTransaction().replace(R.id.framlayout,new BlankFragment()).commit();
        this.setTheme(R.style.AppTheme);
    }
}
