package com.programacionymas.trucktrackphone.io;

import com.programacionymas.trucktrackphone.model.Travel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {

    @GET("travels/pending")
    Call<ArrayList<Travel>> getPendingTravels();

}
