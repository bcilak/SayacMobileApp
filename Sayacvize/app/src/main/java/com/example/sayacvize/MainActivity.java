package com.example.sayacvize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView yazandeger;
        Button eksibuton;
        Button artibuton;
        Button secenek;
        Sharedpre sharedpre;
        //MediaPlayer mediaPlayer;
        Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sharedpre = Sharedpre.getInstance(this);
        //mediaPlayer=MediaPlayer.create(this,R.raw.Claret);
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        yazandeger=(TextView)findViewById(R.id.deger);

        eksibuton=(Button)findViewById(R.id.butoneksi);

        artibuton=(Button)findViewById(R.id.butonarti);
        secenek=(Button)findViewById(R.id.secenekler);
        yazandeger.setText(String.valueOf((sharedpre.yenideger)));

        eksibuton.setOnClickListener(view -> {
            uValues(-1);
        });

        artibuton.setOnClickListener(view -> {
            uValues(1);
        });
        secenek.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Settings.class));
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        sharedpre.sValues();
    }
    private void uValues(int step){
        if (step>0){
            if (sharedpre.yenideger + step> sharedpre.ustlimit){
                if (sharedpre.ustlimitses){
                    ses();
                }
                if (sharedpre.ustlimittitresim){
                    titresim();
                }
                sharedpre.yenideger = sharedpre.ustlimit;
            }
            else{sharedpre.yenideger += step ;
            }

        }
        else{
            if (sharedpre.yenideger+ step < sharedpre.altlimit){
                if (sharedpre.altlimitses){
                    ses();

                }
                if (sharedpre.altlimittitresim){
                    titresim();

                }
                sharedpre.yenideger = sharedpre.altlimit;
            }
            else{sharedpre.yenideger += step ;
            }

        }


        yazandeger.setText(String.valueOf((sharedpre.yenideger)));
    }
    private void ses(){
       // mediaPlayer.seekTo(0);
       // mediaPlayer.start();
    }
    private void titresim(){
        if (!vibrator.hasVibrator())
            return;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE));
            }
        else{
                vibrator.vibrate(1000);
            }

    }
    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){
        if (keyCode== KeyEvent.KEYCODE_VOLUME_UP){
            uValues( 5);
        }
        else if (keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
            uValues((-5));

        }
        return true;
    }
}