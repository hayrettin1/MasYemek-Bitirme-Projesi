package com.example.masyemek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


import java.util.ArrayList;

public class Corbalar extends AppCompatActivity {


    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corbalar);



        mySearchView = (SearchView)findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);

        list = new ArrayList<String>();

        list.add("Mercimek Çorbası");
        list.add("Tarhana Çorbası");
        list.add("Ezogelin Çorbası");
        list.add("Brokoli Çorbası");
        list.add("Kereviz Çorbası");




        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent(Corbalar.this, merciimek.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(Corbalar.this, tarhana.class);
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(Corbalar.this, ezogelin.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(Corbalar.this, brokoli.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(Corbalar.this, kereviz.class);
                    startActivity(intent);
                }

            }
        });



        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}
