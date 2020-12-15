package com.yigit.odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class hub extends AppCompatActivity {
    LinearLayout main;
    String tema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        main=findViewById(R.id.main);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            tema=bundle.getString("tema");
        }
        if(tema.equals("koyu")){
            main.setBackgroundColor(Color.parseColor("#000000"));
        }else{
            main.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        tools();
    }
    Button calc, taksit,list;
    private void tools(){
        calc=findViewById(R.id.cal);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Calc.class);
                startActivity(intent);
            }
        });
        taksit=findViewById(R.id.kredi);
        taksit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),KrediTaksit.class);
                startActivity(intent);
            }
        });
        list=findViewById(R.id.listview);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),List.class);
                startActivity(intent);
            }
        });
    }
}