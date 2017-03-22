package com.example.rookie.weather;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.rookie.weather.db.WeatherData;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import util.CityAdapter;
import util.CityManageItemTouchHelper;

public class CityManage extends AppCompatActivity {
    private List<WeatherData> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manage);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.city_recyclerview);
        list= DataSupport.findAll(WeatherData.class);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        CityAdapter cityAdapter=new CityAdapter(list);
        recyclerView.setAdapter(cityAdapter);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CityManage.this,WeatherActivity.class);
                startActivity(intent);
            }
        });
        ItemTouchHelper.Callback callback = new CityManageItemTouchHelper(cityAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CityManage.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
