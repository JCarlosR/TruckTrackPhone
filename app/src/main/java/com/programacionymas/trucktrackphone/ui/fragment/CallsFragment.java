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
import com.programacionymas.trucktrackphone.model.EmergencyCall;
import com.programacionymas.trucktrackphone.ui.adapter.EmergencyCallAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment implements Callback<ArrayList<EmergencyCall>> {

    private RecyclerView mRecyclerView;
    private EmergencyCallAdapter mAdapter;

    public CallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_calls, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new EmergencyCallAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Call<ArrayList<EmergencyCall>> call = MyApiAdapter.getApiService().getPendingEmergencyCalls();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<EmergencyCall>> call, Response<ArrayList<EmergencyCall>> response) {
        if (response.isSuccessful()) {
            ArrayList<EmergencyCall> EmergencyCalls = response.body();
            mAdapter.setAll(EmergencyCalls);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<EmergencyCall>> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
