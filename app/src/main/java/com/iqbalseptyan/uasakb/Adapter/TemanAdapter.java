package com.iqbalseptyan.uasakb.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iqbalseptyan.uasakb.Activity.DetailActivity;
import com.iqbalseptyan.uasakb.Model.TemanModel;
import com.iqbalseptyan.uasakb.R;

import java.util.List;


/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 09-08-2019
*/
public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.MyViewHolder> {
    private List<TemanModel> temanModels;
    Context context;

    public TemanAdapter(Context context, List<TemanModel> temanModels){
        this.context = context;
        this.temanModels = temanModels;
    }

    @Override
    public TemanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(TemanAdapter.MyViewHolder holder, int position) {
        final TemanModel model = temanModels.get(position);
        holder.nim.setText(model.getNim());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.telepon.setText(model.getTelepon());
        holder.email.setText(model.getEmail());
        holder.medsos.setText(model.getMedsos());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nim", model.getNim());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("kelas", model.getKelas());
                intent.putExtra("telepon", model.getTelepon());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("medsos", model.getMedsos());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temanModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, telepon, email, medsos;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            telepon = itemView.findViewById(R.id.tvTelepon);
            email = itemView.findViewById(R.id.tvEmail);
            medsos = itemView.findViewById(R.id.tvMedsos);
        }
    }
}