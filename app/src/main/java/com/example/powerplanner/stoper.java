package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class stoper extends AppCompatActivity {

    ImageView iv1, iv2, iv3;
    Chronometer tv;
    private boolean isResume;
    Handler handler;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoper);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        iv1 = findViewById(R.id.play);
        iv2 = findViewById(R.id.pause);
        iv3 = findViewById(R.id.reset);
        tv = findViewById(R.id.stoper);

        handler = new Handler();

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isResume){
                    tStart = SystemClock.uptimeMillis();
                    handler.postDelayed(runnable,0);
                    tv.start();
                    isResume = true;
                }else{
                    tBuff += tMilliSec;
                    handler.removeCallbacks(runnable);
                    tv.stop();
                    isResume = false;
                }

            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isResume){
                    //
                }
                tMilliSec = 0L;
                tStart = 0L;
                tBuff = 0L;
                tUpdate = 0L;
                sec = 0;
                min = 0;
                milliSec = 0;
                tv.setText("00:00.00");
            }
        });
    }

    public Runnable runnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            tMilliSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff + tMilliSec;
            sec = (int) (tUpdate/1000);
            min = sec/60;
            sec = sec%60;
            milliSec = (int) (tUpdate%100);
            tv.setText(String.format("%02d", min)+":"
            +String.format("%02d",sec)+"."
            +String.format("%02d",milliSec)
            );

            handler.postDelayed(this, 60);
        }
    };
}