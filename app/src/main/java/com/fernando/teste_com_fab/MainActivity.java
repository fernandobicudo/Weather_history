package com.fernando.teste_com_fab;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText locationEditText;
    private ListView cityListView;
    private CityArrayAdapter cityAdapter;
    private List<String> cityList = new ArrayList<>();
    private TextView cityTextView;
    private String city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationEditText = findViewById(R.id.locationEditText);
        cityListView = findViewById(R.id.cityListView);
        cityAdapter = new CityArrayAdapter(this, cityList);
        cityListView.setAdapter(cityAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((v) -> {//expressão lambda substituindo o código original


            String city = locationEditText.getEditableText().toString();

            if (city.length() > 2) {
                addCity(city);
            }
        });
    }

    private void addCity(String city) {
        cityList.add(city);
        locationEditText.setText("");
        cityAdapter.notifyDataSetChanged();
    }


    public void weatherActivity(View v) {

        cityTextView = findViewById(R.id.cityTextView);

        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
        city = this.cityTextView.getText().toString();
        intent.putExtra("Value", city);
        startActivity(intent);
        finish();
    }
}
//Pendências
//OK 1- não pode deixar criar uma TextView se campo estiver vazio
//2- Descobrir como permitir que seja criado um setOnClickListener para uma TextView que ainda não existe,
//        ou como criá-lo somente quando a TextView for criada.class