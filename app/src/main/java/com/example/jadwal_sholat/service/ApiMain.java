package com.example.jadwal_sholat.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {

    private Retrofit retrofit;

    public WaktuSholatRespository getApiWaktuSholat(){
        String BASE_URL = "http://api.aladhan.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(WaktuSholatRespository.class);
    }
}
