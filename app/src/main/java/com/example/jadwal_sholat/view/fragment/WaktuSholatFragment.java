package com.example.jadwal_sholat.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwal_sholat.R;
import com.example.jadwal_sholat.adapter.WaktuSholatAdapter;
import com.example.jadwal_sholat.model.waktusholat.DataItem;
import com.example.jadwal_sholat.viewmodel.WaktuSholatViewModel;

import java.util.ArrayList;

public class WaktuSholatFragment extends Fragment {
    private RecyclerView rvWaktuSholatDiscover;
    private WaktuSholatAdapter waktuholatDiscoverAdapter;
    private WaktuSholatViewModel waktuSholatViewModel;


    public WaktuSholatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_waktu_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        waktuholatDiscoverAdapter = new WaktuSholatAdapter(getContext());
        waktuholatDiscoverAdapter.notifyDataSetChanged();

        rvWaktuSholatDiscover = view.findViewById(R.id.fragmentwaktu_rv);
        rvWaktuSholatDiscover.setLayoutManager(new LinearLayoutManager(getContext()));

        waktuSholatViewModel = new ViewModelProvider(this).get(WaktuSholatViewModel.class);
        waktuSholatViewModel.setWaktuSholatDiscover();
        waktuSholatViewModel.getWaktuSholatDiscover().observe(getViewLifecycleOwner(), getWaktuSholatDiscover);

        rvWaktuSholatDiscover.setAdapter(waktuholatDiscoverAdapter);
    }

    private Observer<ArrayList<DataItem>> getWaktuSholatDiscover = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
           if (dataItems != null){
               waktuholatDiscoverAdapter.setData(dataItems);
           }
        }
    };
}