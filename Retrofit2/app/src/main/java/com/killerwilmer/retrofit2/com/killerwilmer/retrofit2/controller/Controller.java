package com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.interfaz.TinpuAPI;
import com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.model.cityModel;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by killerwilmer on 3/12/17.
 */

public class Controller implements Callback<List<cityModel>> {


    static final String BASE_URL = "http://192.168.100.74/api_tumenu/";

    List<cityModel> cities = null;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + "cityservice/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TinpuAPI tinpuAPI = retrofit.create(TinpuAPI.class);

        Call<List<cityModel>> call = tinpuAPI.getCities();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call call, Response response) {
        cities = (List<cityModel>) response.body();

        if (cities != null) {
            List<cityModel> changesList = (List<cityModel>) response.body();

            for (cityModel list : changesList) {
                Log.i("City ", list.getName());
            }
        } else {
            Log.i("City Null", "Null");
            try {
                Log.i("City Error", response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        t.printStackTrace();
    }
}
