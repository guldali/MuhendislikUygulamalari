package com.example.gldali.muhendislikuygulamalari;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText degisken1, degisken2,sin,cos;
    Button hesapla;
    TextView sonuc, bilgi ,uyari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        degisken1 = findViewById(R.id.degisken1);
        degisken2 = findViewById(R.id.degisken2);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        hesapla = findViewById(R.id.hesapla);
        sonuc = findViewById(R.id.sonuc);
        bilgi = findViewById(R.id.textView);
        uyari = findViewById(R.id.textView2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String value = extras.getString("send_string");
        bilgi.setText(value);


        hesapla.setOnClickListener(new View.OnClickListener()

        {

            public void onClick(View v) {

                if (degisken1.getText().toString().isEmpty() || degisken2.getText().toString().isEmpty() || sin.getText().toString().isEmpty()
                        || cos.getText().toString().isEmpty()) {
                    sonuc.setText("Lütfen Tüm Alanları Doldurun...");
                } else {
                    float sayi1float = Float.parseFloat(degisken1.getText().toString());//yükseklik
//sayi1 içerisindeki değeri getText ile aldırıp floata
//çevirip sayi1float değişkenine aktarıyoruz. (sayi2 içinde altta)
                    float sayi2float = Float.parseFloat(degisken2.getText().toString());//uzunluk
                    float sayi3float = Float.parseFloat(sin.getText().toString());//x
                    float sayi4float = Float.parseFloat(cos.getText().toString());//y

                    String yazi = bilgi.getText().toString();
                    if (yazi.contentEquals("eğim hesaplayınız  Formül : m = y/x")) {


                        degisken1.setVisibility(View.INVISIBLE);
                        degisken2.setVisibility(View.INVISIBLE);

                        sonuc.setText(String.valueOf(sayi4float / sayi3float));


                    } else if (yazi.contentEquals("koordinat dönüşümü hesaplayınız Formül : X = yükseklik.cos y=yükseklik.sin")) {

                        try {
                            degisken2.setVisibility(View.INVISIBLE);

                            sonuc.setText(String.valueOf(sayi1float * Math.cos(sayi4float)));
                        }
                        catch (ArithmeticException e) {
                            sonuc.setText("Girilen değer geçersiz."+e.toString());
                        }
                    } else if (yazi.contentEquals("standart sapma hesaplayınız : ((x-y(ort))*(x-y(ort))/0.5)")) {
                        degisken1.setVisibility(View.INVISIBLE);
                        degisken2.setVisibility(View.INVISIBLE);

                        sonuc.setText(String.valueOf(((sayi3float - sayi4float) * (sayi3float - sayi4float)) * 0.5));

                    } else if (yazi.contentEquals("alan hesaplayınız Yamuk Alan = ((x+y)/2).yükseklik")) {
                        degisken2.setVisibility(View.INVISIBLE);

                        sonuc.setText(String.valueOf(((sayi3float + sayi4float) / 2) * sayi1float));
                    } else if (yazi.contentEquals("grad dönüşümü hesaplayınız : grad = (x/400)*360")) {
                        degisken1.setVisibility(View.INVISIBLE);
                        degisken2.setVisibility(View.INVISIBLE);
                        cos.setVisibility(View.INVISIBLE);
                        sonuc.setText(String.valueOf((sayi3float / 400) * 360));
                    } else if (yazi.contentEquals("Ölçek Bilgisi hesaplayınız : Ölçek = harita yükseklik/gerçek uzunluk")) {
                        sin.setVisibility(View.INVISIBLE);
                        cos.setVisibility(View.INVISIBLE);

                        sonuc.setText(String.valueOf(sayi1float/sayi2float));
                    } else if (yazi.contentEquals("Bölge Belirleme hesaplayınız ")) {
                        degisken1.setVisibility(View.INVISIBLE);
                        degisken2.setVisibility(View.INVISIBLE);

                        if (sayi4float > 0 && sayi3float > 0) {
                            sonuc.setText("1.Bölge");
                        } else if (sayi4float > 0 && sayi3float < 0) {//y+ x-
                            sonuc.setText("2.Bölge");
                        } else if (sayi4float < 0 && sayi3float < 0) {
                            sonuc.setText("3.Bölge");
                        } else if (sayi4float < 0 && sayi3float > 0) {//y- x+
                            sonuc.setText("4.Bölge");
                        }
                        else if(sayi3float==0){
                            sonuc.setText("Y düzlemi üzerindedir");
                        }
                        else if(sayi4float==0){
                            sonuc.setText("X düzlemi üzerindedir");
                        }

                    } else {
                        sonuc.setText("Cevap Yanlış");
                    }


                }
            }
        });
    }



}

/* Log.d(baslik,"Log.d Debug için kullanılır.Method çalıştımı. Döngüye girdimi.İf çalıştımı. Mavi renkte çıktı verir");
 Log.e(baslik,"Log.e Hata oluşan yer için. Kırmızı Renkte çıktı verir");
 Log.w(baslik,"Log.w Uyarı(Warnings) .Turuncu renk çıktı verir");
 Log.i(baslik, "Log.i Bilgilendirme amaçlı.Yeşil renk çıktı verir");
 */