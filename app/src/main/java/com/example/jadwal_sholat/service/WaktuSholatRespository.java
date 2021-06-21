package com.example.jadwal_sholat.service;

import com.example.jadwal_sholat.model.waktusholat.WaktuSholatResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface WaktuSholatRespository {
    @GET("v1/calendarByAddress?address=Yogyakarta&method=2&month=06&year=2021")
    Call<WaktuSholatResponse> getWaktuSholatDiscover();
}
