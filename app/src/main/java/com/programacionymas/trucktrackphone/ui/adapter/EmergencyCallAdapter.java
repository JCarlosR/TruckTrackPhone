package com.programacionymas.trucktrackphone.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.programacionymas.trucktrackphone.R;
import com.programacionymas.trucktrackphone.model.EmergencyCall;

import java.util.ArrayList;

public class EmergencyCallAdapter extends RecyclerView.Adapter<EmergencyCallAdapter.ViewHolder> {
    private ArrayList<EmergencyCall> mDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvRouteName, tvDriverName, tvEmergencyCallId, tvCreatedAt;
        private Button btnGoogleMaps;

        public ViewHolder(View v) {
            super(v);
            tvEmergencyCallId = v.findViewById(R.id.tvEmergencyCallId);
            tvRouteName = v.findViewById(R.id.tvRouteName);
            tvDriverName = v.findViewById(R.id.tvDriverName);
            tvCreatedAt = v.findViewById(R.id.tvCreatedAt);
            btnGoogleMaps = v.findViewById(R.id.btnGoogleMaps);
        }
    }

    public EmergencyCallAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setAll(ArrayList<EmergencyCall> calls) {
        mDataSet = calls;
        notifyDataSetChanged();
    }

    @Override
    public EmergencyCallAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_emergency_call, parent, false);

        context = v.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        final EmergencyCall emergencyCall = mDataSet.get(position);
        holder.tvEmergencyCallId.setText("Llamada # " + emergencyCall.getId());
        holder.tvDriverName.setText("Enviado por " + emergencyCall.getUser().getName());
        holder.tvRouteName.setText("Desde la ruta " + emergencyCall.getRouteName());
        holder.tvCreatedAt.setText(emergencyCall.getCreatedAt());
        holder.btnGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/"+emergencyCall.getLat()+","+emergencyCall.getLng()));
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}