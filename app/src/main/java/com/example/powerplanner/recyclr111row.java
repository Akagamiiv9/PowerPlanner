package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class recyclr111row extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CheckBox checkBox = findViewById(R.id.checkBox);
        CardView cardView = findViewById(R.id.cardView);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked())
                {
                    //cb.setBackgroundColor(Color.BLUE);
                    //cardView.backgro;
                }
                else
                {
                    // Not Checked
                    // Set Your Default Color.
                }
            }
        });

    }
}