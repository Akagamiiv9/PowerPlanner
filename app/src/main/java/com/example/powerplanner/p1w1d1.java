package com.example.powerplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.math.RoundingMode;
import java.util.ArrayList;

public class p1w1d1 extends AppCompatActivity {

    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;

    ArrayList<mojmodel> mojmodels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1w1d1);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.night)));
        getSupportActionBar().setTitle("");

        recyclerView= findViewById(R.id.recycle111);

        setUpModels();

        recyclerAdapter adapter = new recyclerAdapter(this, mojmodels);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpModels(){
        String[] modelCW = getResources().getStringArray(R.array.cw);
        String[] modelPR= getResources().getStringArray(R.array.pr);
        String[] modelPO = getResources().getStringArray(R.array.po);
        String[] modelSE = getResources().getStringArray(R.array.se);

        String be, oh;

        sharedPreferences = getSharedPreferences("SHARED_PREF",0);
        if(sharedPreferences.getString("BENCH","")== ""){
            be = "0";
        }else{
            be = sharedPreferences.getString("BENCH","");
        }
        if(sharedPreferences.getString("OHP","")== ""){
            oh = "0";
        }else{
            oh = sharedPreferences.getString("OHP","");
        }
        for (int i = 0; i<modelCW.length; i++){
            if(i == 0){
                mojmodels.add(new mojmodel(modelCW[i],
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(be)*0.9/2.5)*2.5)));
            }else if(i >= 1 && i<9){
                mojmodels.add(new mojmodel("",
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(be)*0.9/2.5)*2.5)));
            }else if(i == 9){
                mojmodels.add(new mojmodel(modelCW[i],
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(oh)*0.9/2.5)*2.5)));
            }else if(i >= 9 && i<17){
                mojmodels.add(new mojmodel("",
                        modelPO[i],
                        modelSE[i],
                        String.valueOf(Math.round(Double.parseDouble("0."+modelPR[i].toString())*Double.parseDouble(oh)*0.9/2.5)*2.5)));
            }else{
                mojmodels.add(new mojmodel(modelCW[i], modelPO[i], modelSE[i], modelPR[i]));
                Log.d("else", modelCW[i]);
            }
        }
    }
}