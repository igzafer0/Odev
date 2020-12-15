package com.yigit.odev;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    private String[] kullanicilar =
            {"Yiğit", "Zafer", "Ali", "Ayşe","Mehmet",
                    "Muhammet"};
    private ArrayList x;
    BottomSheetDialog bottomSheetDialog;
    ArrayList<String> isimler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       isimler= new ArrayList<String>();
       isimler.add("Yiğit");
       isimler.add("Zafer");
       isimler.add("Ali");

        ListView listemiz=(ListView) findViewById(R.id.listview);
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, isimler);

        ImageView add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuptools();
            }
        });
        listemiz.setAdapter(veriAdaptoru);
    }

    private void setuptools(){
        try {

            final View view = getLayoutInflater().inflate(R.layout.addbottom, null);
            AlertDialog alertDialog = new AlertDialog.Builder(List.this).create();
            alertDialog.setTitle("Kullanıcı ekle");
            alertDialog.setCancelable(false);

            final EditText etComments = (EditText) view.findViewById(R.id.etComments);
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                        if(etComments.getText().toString().isEmpty()){
                            Toast.makeText(getApplicationContext(),"Boş bırakma",Toast.LENGTH_LONG);
                        }else{
                            isimler.add(etComments.getText().toString());
                        }
                }
            });


            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });


            alertDialog.setView(view);
            alertDialog.show();
        }catch (Exception e){
            Log.d("winter",e.getMessage());
        }
       }
}