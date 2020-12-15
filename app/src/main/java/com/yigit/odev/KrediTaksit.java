package com.yigit.odev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class KrediTaksit extends AppCompatActivity {
    Button hesapla;
    EditText kredi,taksit,sonuc;
    RadioGroup rg;
    RadioButton faiz1,faiz2,faiz3;
    double x = 0.01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kredi_taksit);
        rg=findViewById(R.id.rg);
        faiz1=findViewById(R.id.faiz1);
        faiz2=findViewById(R.id.faiz2);
        kredi=findViewById(R.id.kredi);
        taksit=findViewById(R.id.taksit);
        sonuc=findViewById(R.id.sonuc);
        faiz3=findViewById(R.id.faiz3);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(faiz1.isChecked()){
                    x = 0.01;
                }else if(faiz2.isChecked()){
                    x = 0.02;
                }else {
                    x = 0.05;
                }
            }
        });
        hesapla=findViewById(R.id.hesapet);
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText(String.valueOf(
                       Integer.parseInt(kredi.getText().toString())*
                       (x*Math.pow(1+x,Double.parseDouble(taksit.getText().toString()))/(Math.pow(1+x,Double.parseDouble(taksit.getText().toString()))-1))));
            }
        });

    }
}