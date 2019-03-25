package com.fernando.teste_com_fab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText locationEditText;
    private ListView cityListView;
    private CityArrayAdapter cityAdapter;
    private List<String> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationEditText = findViewById(R.id.locationEditText);
        cityListView = findViewById(R.id.cityListView);
        cityAdapter = new CityArrayAdapter(this, cityList);
        cityListView.setAdapter(cityAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((v)->{//expressão lambda substituindo o código original
            String city = locationEditText.getEditableText().toString();

            addCity(city);

        });
    }

    private void addCity(String city) {
        cityList.add(city);
        locationEditText.setText("");
        cityAdapter.notifyDataSetChanged();
    }
}
