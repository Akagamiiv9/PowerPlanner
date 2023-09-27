package com.example.powerplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<mojmodel> mojmodels;

    public recyclerAdapter(Context context, ArrayList<mojmodel> mojmodels){
        this.context = context;
        this.mojmodels = mojmodels;
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclr111row, parent, false);

        return new recyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        holder.tvCW.setText(mojmodels.get(position).getCw());
        holder.tvPO.setText(mojmodels.get(position).getPo());
        holder.tvPR.setText(mojmodels.get(position).getPr());
        holder.tvSE.setText(mojmodels.get(position).getSe());

    }

    @Override
    public int getItemCount() {
        return mojmodels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvCW, tvPO, tvPR, tvSE;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCW = itemView.findViewById(R.id.tvcwiczenie);
            tvPO = itemView.findViewById(R.id.tvpowtorzenie);
            tvPR = itemView.findViewById(R.id.tvprocent);
            tvSE = itemView.findViewById(R.id.tvseria);

        }
    }
}
