package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class plan2 extends AppCompatActivity {

    TextView maxy;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        Button btn1 = findViewById(R.id.day1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan2.this, p2d1.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.day2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan2.this, p2d2.class);
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.day3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan2.this, p2d3.class);
                startActivity(intent);
            }
        });

        Button btn4 = findViewById(R.id.day4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan2.this, p2d4.class);
                startActivity(intent);
            }
        });

        Button btn5 = findViewById(R.id.day5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plan2.this, p2d5.class);
                startActivity(intent);
            }
        });

        maxy = findViewById(R.id.maxy);

        sharedPreferences = getSharedPreferences("SHARED_PREF",0);

        String s = sharedPreferences.getString("SQUAT","0");
        String b = sharedPreferences.getString("BENCH","0");
        String d = sharedPreferences.getString("DEADLIFT","0");
        String o = sharedPreferences.getString("OHP","0");

        maxy.setText("S: "+s+" B: "+b+" D: "+d+ " O: "+o);
    }
}