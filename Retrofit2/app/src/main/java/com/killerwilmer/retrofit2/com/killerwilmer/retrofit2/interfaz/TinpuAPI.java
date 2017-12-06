package com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.interfaz;

import com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.model.cityModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by killerwilmer on 3/12/17.
 */

public interface TinpuAPI {

    @GET("allcities/")
    Call<List<cityModel>> getCities();

}
