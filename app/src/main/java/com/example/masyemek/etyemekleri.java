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

public class etyemekleri extends AppCompatActivity {

    SearchView mySearchView;
    ListView myList;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etyemekleri);

        mySearchView = (SearchView)findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.myList);

        list = new ArrayList<String>();

        list.add("Parmak Kebabı");
        list.add("Kıymalı Tirit");
        list.add("Kilis Tava");
        list.add("Et Sote");
        list.add("Rosto Köfte");
        list.add("Hünkar Beğendi");
        list.add("Sac Kavurma");



        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(etyemekleri.this, parmakkebap.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(etyemekleri.this, tirit.class);
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(etyemekleri.this, kilistava.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(etyemekleri.this, etsote.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(etyemekleri.this, rosto.class);
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
