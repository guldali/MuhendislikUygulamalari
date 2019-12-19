package com.example.gldali.muhendislikuygulamalari;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button button;
    ListView list;
    String record="Merhba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();
        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.formüller,android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

              switch (position){
                  case 0:
                   record="eğim hesaplayınız  Formül : m = y/x";
                   break;
                  case 1:
                      record="koordinat dönüşümü hesaplayınız Formül : X = yükseklik.cos y=yükseklik.sin";
                      break;
                  case 2:
                      record="standart sapma hesaplayınız : ((x-y(ort))*(x-y(ort))/0.5)";
                      break;
                  case 3:
                      record="alan hesaplayınız Yamuk Alan = ((x+y)/2).yükseklik";
                      break;
                  case 4:
                      record="grad dönüşümü hesaplayınız : grad = (x/400)*360";
                      break;
                  case 5:
                      record="Ölçek Bilgisi hesaplayınız : Ölçek = harita yükseklik/gerçek uzunluk";
                      break;
                  case 6:
                      record="Bölge Belirleme hesaplayınız ";
                      break;

              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Ardından Intent methodunu kullanarak nereden nereye gideceğini söylüyoruz.
                //MainActivity sayfasından Main2Activity sayfasına geçiş yapıyoruz.
                Intent intocan = new Intent(MainActivity.this, Main2Activity.class);
                intocan.putExtra("send_string",record);
                startActivity(intocan);

            }


        });


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
}
