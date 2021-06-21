package com.example.jadwal_sholat.view.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.jadwal_sholat.R;
import com.example.jadwal_sholat.adapter.WaktuSholatAdapter;
import com.example.jadwal_sholat.database.AppDatabase;
import com.example.jadwal_sholat.database.DataInput;
import com.example.jadwal_sholat.database.DataInputAdapter;
import com.example.jadwal_sholat.database.InputActivity;
import com.example.jadwal_sholat.database.LihatDataActivity;
import com.example.jadwal_sholat.viewmodel.WaktuSholatViewModel;


public class PengaturanFragment extends Fragment {
    AppDatabase appDatabase;
    Button btnSimpan, btnLihat;
    EditText etJudul,etNote;

    public PengaturanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnSimpan = view.findViewById(R.id.btn_simpan);
        btnLihat = view.findViewById(R.id.btn_lihat);

        etJudul = view.findViewById(R.id.et_judul);
        etNote = view.findViewById(R.id.et_note);

        appDatabase = AppDatabase.iniDB(getContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataInput dataInput = new DataInput();

                dataInput.setJudul(etJudul.getText().toString());
                dataInput.setNote(etNote.getText().toString());

                appDatabase.dao().insertData(dataInput);

                etJudul.setText("");
                etNote.setText("");
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LihatDataActivity.class);

                startActivity(intent);

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pengaturan, container, false);
    }
}