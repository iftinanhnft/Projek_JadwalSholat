package com.example.jadwal_sholat.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jadwal_sholat.R;

public class JadwalDetail extends AppCompatActivity {

    TextView tvImsak, tvSubuh, tvDhuhur, tvAsr, tvMaghrib, tvIsha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_detail);
        tvImsak = findViewById(R.id.tv_pray_time_imsak);
        //tvSubuh = findViewById(R.id.tv_pray_time_fajr);
        tvDhuhur = findViewById(R.id.tv_pray_time_dhuhr);
        tvAsr = findViewById(R.id.tv_pray_time_asr);
        tvMaghrib = findViewById(R.id.tv_pray_time_maghrib);
        tvIsha = findViewById(R.id.tv_pray_time_isha);
        getIncomingIntent();


    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String getImsak = bundle.getString("dImsak");
            //String getSubuh = bundle.getString("dShubuh");
            String getDhuhur = bundle.getString("dDhuhur");
            String getAsr = bundle.getString("dAsr");
            String getMaghrib= bundle.getString("dMaghrib");
            String getIsha = bundle.getString("dIsha");

            tvImsak.setText(getImsak);
            //tvSubuh.setText(getSubuh);
            tvDhuhur.setText(getDhuhur);
            tvAsr.setText(getAsr);
            tvMaghrib.setText(getMaghrib);
            tvIsha.setText(getIsha);
        }
        else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.list:
                Intent intent = new Intent(this, com.example.jadwal_sholat.view.activity.MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}