package com.example.jadwal_sholat.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.jadwal_sholat.R;

import java.util.ArrayList;

public class LihatDataActivity extends AppCompatActivity {

    private DataInputAdapter dataInputAdapter;
    private RecyclerView rvdatainput;
    private AppDatabase appDatabase;
    private ArrayList<DataInput> listdatainput = new ArrayList<DataInput>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        rvdatainput = findViewById(R.id.rv_lihatdata);
        dataInputAdapter = new DataInputAdapter(getApplicationContext());
        dataInputAdapter.notifyDataSetChanged();

        if (appDatabase == null){
            appDatabase = AppDatabase.iniDB(getApplicationContext());
        }

        listdatainput.addAll(appDatabase.dao().getData());
        dataInputAdapter.setDatainputItem(listdatainput);

        rvdatainput.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvdatainput.setAdapter(dataInputAdapter);
    }
}