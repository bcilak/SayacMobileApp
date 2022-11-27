package com.example.sayacvize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    TextView utext;
    TextView atext;
    Button arti;
    Button arti2;
    Button eksi;
    Button eksi2;
    Switch switch1;
    Switch switch2;
    Switch switch3;
    Switch switch4;
    Sharedpre sharedpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpre = Sharedpre.getInstance(this);
        setContentView(R.layout.activity_settings);
        utext= (TextView) findViewById(R.id.utext);
        atext= (TextView) findViewById(R.id.atext);
        arti=(Button)findViewById(R.id.arti);
        arti2=(Button)findViewById(R.id.arti2);
        eksi=(Button)findViewById(R.id.eksi);
        eksi2=(Button)findViewById(R.id.eksi2);
        switch1=(Switch) findViewById(R.id.switch1);
        switch2=(Switch) findViewById(R.id.switch2);
        switch3=(Switch) findViewById(R.id.switch3);
        switch4=(Switch) findViewById(R.id.switch4);
        arti.setOnClickListener(view -> {
            sharedpre.ustlimit++;
            utext.setText(String.valueOf(sharedpre.ustlimit));
        });
        eksi.setOnClickListener(view -> {
            sharedpre.ustlimit--;
            utext.setText(String.valueOf(sharedpre.ustlimit));
        });
        arti2.setOnClickListener(view -> {
            sharedpre.altlimit++;
            atext.setText(String.valueOf(sharedpre.altlimit));
        });
        eksi2.setOnClickListener(view -> {
            sharedpre.altlimit--;
            atext.setText(String.valueOf(sharedpre.altlimit));
        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sharedpre.ustlimitses=b;
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sharedpre.ustlimittitresim=b;
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sharedpre.altlimitses=b;
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sharedpre.altlimittitresim=b;
            }
        });

     }
    @Override
    protected void onResume(){
        super.onResume();
        utext.setText((String.valueOf(sharedpre.ustlimit)));
        atext.setText((String.valueOf(sharedpre.altlimit)));

        switch1.setChecked(sharedpre.ustlimitses);
        switch2.setChecked(sharedpre.ustlimittitresim);
        switch3.setChecked(sharedpre.altlimitses);
        switch4.setChecked(sharedpre.altlimittitresim);

    }
}