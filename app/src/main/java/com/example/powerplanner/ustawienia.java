package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ustawienia extends AppCompatActivity {

    EditText squatET, benchET, deadliftET, ohpET;
    TextView tv;
    Button btnZapisz;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia);
        btnZapisz = findViewById(R.id.aaa);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        squatET = findViewById(R.id.squat);
        benchET = findViewById(R.id.bench);
        deadliftET = findViewById(R.id.deadlift);
        ohpET = findViewById(R.id.ohp);
        tv = findViewById(R.id.textView2);


        sharedPreferences = getSharedPreferences("SHARED_PREF",0);

        squatET.setText(sharedPreferences.getString("SQUAT","0"));
        benchET.setText(sharedPreferences.getString("BENCH","0"));
        deadliftET.setText(sharedPreferences.getString("DEADLIFT","0"));
        ohpET.setText(sharedPreferences.getString("OHP","0"));

        if(squatET.getText().toString().isEmpty()
                && benchET.getText().toString().isEmpty()
                && deadliftET.getText().toString().isEmpty()
                && ohpET.getText().toString().isEmpty()){
            tv.setText("Podaj swoje");
        }else{
            tv.setText("Zmień swoje");
        }

        btnZapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                squatET = findViewById(R.id.squat);
                benchET = findViewById(R.id.bench);
                deadliftET = findViewById(R.id.deadlift);
                ohpET = findViewById(R.id.ohp);


                sharedPreferences = getSharedPreferences("SHARED_PREF",0);

                String sq = squatET.getText().toString();
                String be = benchET.getText().toString();
                String dl = deadliftET.getText().toString();
                String oh = ohpET.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("SQUAT", sq);
                editor.putString("BENCH", be);
                editor.putString("DEADLIFT", dl);
                editor.putString("OHP", oh);

                editor.apply();

                Intent intent = new Intent(ustawienia.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }


}