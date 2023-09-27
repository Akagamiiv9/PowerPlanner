package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public int intLayout = 1;
    TextView maxy;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");


        Button btn1 = findViewById(R.id.plany);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, gotoweplany.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.btnustawienia);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ustawienia1.class);
                startActivity(intent);
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, stoper.class);
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

        /*
        RecyclerView recyclerView = findViewById(R.id.recycle111);
        setupModels();

        recyclerAdapter adapter = new recyclerAdapter(this, model);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        */



    }

    /*
    private void setupModels(){
        String[] cwiczenia = getResources().getStringArray(R.array.cwiczenie);
        String[] powtorzenie = getResources().getStringArray(R.array.powtorzenia);
        String[] seria = getResources().getStringArray(R.array.seria);
        String[] procent = getResources().getStringArray(R.array.procent);

        for (int i =0; i<cwiczenia.length; i++){
            model.add(new model (cwiczenia[i], seria[i], powtorzenie[i], procent[i]));
        }
    }

     */

    @Override
    public void onBackPressed(){
        if(intLayout == 2 || intLayout == 3 || intLayout == 4){
            intLayout = 1;
            setContentView(R.layout.activity_main);
        }else if(intLayout == 5 || intLayout == 6 ||intLayout == 7){
            intLayout = 3;
            setContentView(R.layout.activity_gotoweplany);
        }else if(intLayout == 8 || intLayout == 9||intLayout == 10||intLayout == 11){
            intLayout = 5;
            setContentView(R.layout.activity_days4);
        }else{
            super.onBackPressed();
        }

    }

}