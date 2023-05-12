package com.yiriba.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    private static CustomAdapter adapter;


  //  String [] worldCup22 = {"Germany", "France", "Côte D'Ivoire", "Spain", "Brazil", "USA", "Saudi Arabia", "Qatar"};
        ArrayList<Country> dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1- AdapterView
        lv = findViewById(R.id.listview);
        // 2- Data Source
        dataSource = new ArrayList<>();
        dataSource.add(new Country("Côte D'Ivoire", "8", R.drawable.ci));
        dataSource.add(new Country("France", "1", R.drawable.fr));
        dataSource.add(new Country("Inde", "7", R.drawable.india));
        dataSource.add(new Country("Nigéria", "5", R.drawable.ng));
        dataSource.add(new Country("Royaumes Unis", "4", R.drawable.uk));
        dataSource.add(new Country("Vietnam", "6", R.drawable.vietnam));
        dataSource.add(new Country("États Unis", "7", R.drawable.usa));

        // 3- Adapter
        adapter = new CustomAdapter(getApplicationContext(), dataSource);
        lv.setAdapter(adapter);

        // 4 - Handling click events on ListView items
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        "Country: "+ adapter.getItem(position).getCountry_name()+"\n" +
                                "World Cups Wins: "+ adapter.getItem(position).getCup_win_count(),
                        Toast.LENGTH_SHORT).show();
            }
        });
/*
        //  - Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.my_list_item,
                R.id.li_textView,
                worldCup22);
        lv.setAdapter(adapter); */


    }
}