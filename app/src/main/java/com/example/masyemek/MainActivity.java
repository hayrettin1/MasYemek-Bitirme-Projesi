package com.example.masyemek;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private static final int ID_OPTION1 = Menu.FIRST;



    ListView listView;
    String mTitle[] = {"ÇORBALAR", "ET YEMEKLERİ", "TAVUK YEMEKLERİ", "BALIK YEMEKLERİ", "SEBZE YEMEKLERİ", "HAMUR İŞLERİ"};
    String mDescription[] = {"ÇORBALAR TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ ", "ET YEMEKLERİ TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ", "TAVUK YEMEKLERİ TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ", "BALIK YEMEKLERİ TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ", "SEBZE YEMEKLERİ TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ", "HAMUR İŞLERİ TARİFLERİNİ GÖRMEK İÇİN TIKLAYINIZ"};
    int images[] = {R.drawable.corbalar, R.drawable.ettt, R.drawable.tavuk, R.drawable.balik, R.drawable.sebze, R.drawable.hamur};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();



        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0){
                    Toast.makeText(MainActivity.this, "ÇORBALAR", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Corbalar.class);
                    startActivity(i);
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "ET YEMEKLERİ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,etyemekleri.class);
                    startActivity(i);
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "TAVUK YEMEKLERİ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,tavukyemekleri.class);
                    startActivity(i);
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "BALIK YEMEKLERİ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,balikyemekleri.class);
                    startActivity(i);
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "SEBZE YEMEKLERİ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,sebzeyemekleri.class);
                    startActivity(i);
                }
                if (position == 5){
                    Toast.makeText(MainActivity.this, "HAMUR İŞLERİ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,hamurisleri.class);
                    startActivity(i);
                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);


            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, ID_OPTION1, 0, "YÖNETİCİ EKRANI");
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case ID_OPTION1:
                Intent intent = new Intent(MainActivity.this, yoneticiekran.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }



}