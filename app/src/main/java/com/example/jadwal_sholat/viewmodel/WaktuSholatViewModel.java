package com.example.jadwal_sholat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jadwal_sholat.model.waktusholat.DataItem;
import com.example.jadwal_sholat.model.waktusholat.WaktuSholatResponse;
import com.example.jadwal_sholat.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaktuSholatViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listDiscoverWaktuSholat = new MutableLiveData<>();

    public void setWaktuSholatDiscover() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiWaktuSholat().getWaktuSholatDiscover().enqueue(new Callback<WaktuSholatResponse>() {
            @Override
            public void onResponse(Call<WaktuSholatResponse> call, Response<WaktuSholatResponse> response) {
                WaktuSholatResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getData() != null) {
                    ArrayList<DataItem> waktusholatDiscoverItems = responseDiscover.getData();
                    listDiscoverWaktuSholat.postValue(waktusholatDiscoverItems);
                }

            }

            @Override
            public void onFailure(Call<WaktuSholatResponse> call, Throwable t) {

            }
        });
    }

        public LiveData<ArrayList<DataItem>> getWaktuSholatDiscover(){
            return listDiscoverWaktuSholat;
        }

}
