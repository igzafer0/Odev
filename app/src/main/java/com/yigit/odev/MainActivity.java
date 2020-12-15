package com.yigit.odev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<kullanici> kullanici;
    Button login;
    RadioGroup rg;
    RadioButton rb;
    EditText name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          tanimla();

    }
    private void tanimla(){
        login=findViewById(R.id.login);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.password);
        rg=findViewById(R.id.rg);
        kullanici=new ArrayList<>();
        kullanici.add(new kullanici("admin","1234"));
        kullanici.add(new kullanici("yonetici","1234"));
        kullanici.add(new kullanici("yigit","0000"));
        kullanici.add(new kullanici("manager","0000"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < kullanici.size()-1; i++) {
                    if(name.getText().toString().toLowerCase().equals(kullanici.get(i).kadi)){
                        if(pass.getText().toString().toLowerCase().equals(kullanici.get(i).password)){
                            Intent intent = new Intent(getApplicationContext(),hub.class);
                            rb=findViewById(rg.getCheckedRadioButtonId());
                            intent.putExtra("tema",rb.getText().toString());
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }

}