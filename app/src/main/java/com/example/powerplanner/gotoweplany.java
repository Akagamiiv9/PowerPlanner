package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gotoweplany extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gotoweplany);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        Button btn1 = findViewById(R.id.plan1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gotoweplany.this, p1w1.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.plan2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gotoweplany.this, plan2.class);
                startActivity(intent);
            }
        });
    }
}