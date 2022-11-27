package com.example.sayacvize;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.Key;

public class Sharedpre {
    private static Sharedpre Instance;
    public int yenideger = 0;

    public int ustlimit;
    public boolean ustlimitses;
    public boolean ustlimittitresim;

    public int altlimit;
    public boolean altlimitses;
    public boolean altlimittitresim;

    private static final String KEY_yenideger_VALUE="Deger";
    private static final String KEY_ustlimit="ulimit";
    private static final String KEY_ustlimitses="ulimitses";
    private static final String KEY_ustlimittitresim="ulimittitresim";

    private static final String KEY_altlimit="alimit";
    private static final String KEY_altlimitses="alimitses";
    private static final String KEY_altlimittitresim="alimittitresim";



    private SharedPreferences sharedPreferences;



    private Sharedpre(Context context){
        sharedPreferences= context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        lValues();
    }

    public static Sharedpre getInstance(Context context) {
        if (Instance== null){
            Instance=new Sharedpre(context);
        }
        return Instance;
    }
    private void lValues(){
        yenideger= sharedPreferences.getInt(KEY_yenideger_VALUE,0);

        ustlimit= sharedPreferences.getInt(KEY_ustlimit,25);
        ustlimitses=sharedPreferences.getBoolean(KEY_ustlimitses, false);
        ustlimittitresim=sharedPreferences.getBoolean(KEY_ustlimittitresim,true);


        altlimit= sharedPreferences.getInt(KEY_altlimit,0);
        altlimitses=sharedPreferences.getBoolean(KEY_altlimitses,false);
       altlimittitresim=sharedPreferences.getBoolean(KEY_altlimittitresim,true);

    }
    public void sValues(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(KEY_yenideger_VALUE,yenideger);
        editor.putInt(KEY_ustlimit,ustlimit);
        editor.putBoolean(KEY_ustlimitses , ustlimitses);
        editor.putBoolean(KEY_ustlimittitresim,ustlimittitresim);

        editor.putInt(KEY_altlimit,altlimit);
        editor.putBoolean(KEY_altlimitses , altlimitses);
        editor.putBoolean(KEY_altlimittitresim,altlimittitresim);

        editor.commit();
    }
}
