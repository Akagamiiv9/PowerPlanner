package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ustawienia2 extends AppCompatActivity {

    Button button;
    EditText w, r;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustawienia2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        w = findViewById(R.id.weight);
        r = findViewById(R.id.reps);
        tv1 = findViewById(R.id.tv1);

        button = findViewById(R.id.aaa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String we = w.getText().toString();
                String re = r.getText().toString();

                if (we.isEmpty()  || re.isEmpty() || we.equals("0") || re.equals("0") ){
                    Toast.makeText(ustawienia2.this, "Wprowadź wszystkie parametry!", Toast.LENGTH_SHORT).show();
                    tv1.setText("");
                }else{
                    String wynik = String.format("%.2f",(Double.parseDouble(we) / ((1.0278) - (0.0278 * Double.parseDouble(re)))));
                    tv1.setText(wynik);
                }


            }
        });

    }
}