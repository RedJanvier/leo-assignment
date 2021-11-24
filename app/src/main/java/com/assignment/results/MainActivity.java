package com.assignment.results;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar appbar = getSupportActionBar();
        ListView propertiesList = findViewById(R.id.my_list);
        Button designBtn = findViewById(R.id.design_button);

        ArrayList<Property> props = new ArrayList<>();

        Property prop1 = new Property("System size:", "6.50kWp");
        Property prop2 = new Property("System cost:", "$305500.00");
        Property prop3 = new Property("Module @250Wp:", "26no.");
        Property prop4 = new Property("Power generated:", "840.64units/months");
        Property prop5 = new Property("CO2 emission saving:", "554.83Kg");
        Property prop6 = new Property("Share of solar:", "73.44%");
        Property prop7 = new Property("System size:", "6.50kWp");
        Property prop8 = new Property("System size:", "6.50kWp");
        Property prop9 = new Property("System size:", "6.50kWp");

        props.add(prop1);
        props.add(prop2);
        props.add(prop3);
        props.add(prop4);
        props.add(prop5);
        props.add(prop6);
        props.add(prop7);
        props.add(prop8);
        props.add(prop9);

        PropertyListAdapter adapter = new PropertyListAdapter(this, R.layout.property_list_view, props);
        propertiesList.setAdapter(adapter);

        appbar.setElevation(0);
        appbar.setTitle("Quote Result");
        appbar.setDisplayHomeAsUpEnabled(true);
        designBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.design_button:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}