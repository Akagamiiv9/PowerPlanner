package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class p1w1d4 extends AppCompatActivity {
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    ArrayList<mojmodel> mojmodels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1w1d4);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        recyclerView= findViewById(R.id.recycle114);

        setUpModels();

        recyclerAdapter adapter = new recyclerAdapter(this, mojmodels);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpModels(){
        String[] modelCW = getResources().getStringArray(R.array.cw4);
        String[] modelPR= getResources().getStringArray(R.array.pr4);
        String[] modelPO = getResources().getStringArray(R.array.po4);
        String[] modelSE = getResources().getStringArray(R.array.se4);

        String sq, dl;

        sharedPreferences = getSharedPreferences("SHARED_PREF",0);
        if(sharedPreferences.getString("SQUAT","")== ""){
            sq = "0";
        }else{
            sq = sharedPreferences.getString("SQUAT","");
        }
        if(sharedPreferences.getString("DEADLIFT","")== ""){
            dl = "0";
        }else{
            dl = sharedPreferences.getString("DEADLIFT","");
        }
        for (int i = 0; i<modelCW.length; i++){
            if(i == 0){
                mojmodels.add(new mojmodel(modelCW[i],
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(dl)*0.9/2.5)*2.5)));
            }else if(i >= 1 && i<9){
                mojmodels.add(new mojmodel("",
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(dl)*0.9/2.5)*2.5)));
            }else if(i == 9){
                mojmodels.add(new mojmodel(modelCW[i],
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(sq)*0.9/2.5)*2.5)));
            }else if(i >= 9 && i<17){
                mojmodels.add(new mojmodel("",
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(sq)*0.9/2.5)*2.5)));
            }else{
                mojmodels.add(new mojmodel(modelCW[i], modelPO[i], modelSE[i], modelPR[i]));
                Log.d("else", modelCW[i]);
            }
        }
    }
}