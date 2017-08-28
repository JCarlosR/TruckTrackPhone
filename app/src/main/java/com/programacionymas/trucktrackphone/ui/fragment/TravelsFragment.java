package com.programacionymas.trucktrackphone.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.programacionymas.trucktrackphone.R;
import com.programacionymas.trucktrackphone.io.MyApiAdapter;
import com.programacionymas.trucktrackphone.model.Travel;
import com.programacionymas.trucktrackphone.ui.adapter.TravelAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TravelsFragment extends Fragment implements Callback<ArrayList<Travel>> {

    private RecyclerView mRecyclerView;
    private TravelAdapter mAdapter;

    public TravelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_travels, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TravelAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Call<ArrayList<Travel>> call = MyApiAdapter.getApiService().getPendingTravels();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Travel>> call, Response<ArrayList<Travel>> response) {
        if (response.isSuccessful()) {
            ArrayList<Travel> travels = response.body();
            mAdapter.setAll(travels);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Travel>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
