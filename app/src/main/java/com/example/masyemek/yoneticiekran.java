package com.example.masyemek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class yoneticiekran extends AppCompatActivity {

    Button grs_yap;
    Button kyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoneticiekran);

        grs_yap =(Button)findViewById(R.id.grs_yap);

        grs_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yoneticiekran.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        kyt =(Button)findViewById(R.id.kyt);

        kyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yoneticiekran.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
