package com.programacionymas.trucktrackphone.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programacionymas.trucktrackphone.R;
import com.programacionymas.trucktrackphone.model.Travel;

import java.util.ArrayList;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder> {
    private ArrayList<Travel> mDataSet;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRouteName, tvDriverName, tvTravelId, tvDepartureDate, tvDepartureTime;

        public ViewHolder(View v) {
            super(v);
            tvTravelId = v.findViewById(R.id.tvTravelId);
            tvRouteName = v.findViewById(R.id.tvRouteName);
            tvDriverName = v.findViewById(R.id.tvDriverName);
            tvDepartureDate = v.findViewById(R.id.tvDepartureDate);
            tvDepartureTime = v.findViewById(R.id.tvDepartureTime);
        }
    }

    public TravelAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setAll(ArrayList<Travel> travels) {
        mDataSet = travels;
        notifyDataSetChanged();
    }

    @Override
    public TravelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_travel, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido de los views según tales datos

        final Travel travel = mDataSet.get(position);
        holder.tvTravelId.setText("Viaje " + travel.getId());
        holder.tvRouteName.setText(travel.getRouteName());
        holder.tvDriverName.setText(travel.getDriverName());
        holder.tvDepartureDate.setText("El día " + travel.getDepartureDate());
        holder.tvDepartureTime.setText("A las " + travel.getDepartureTime());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}