package com.example.jadwal_sholat.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jadwal_sholat.R;

public class InputActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private Button btnSimpan, btnLihat;
    private EditText etJudul,etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnLihat = findViewById(R.id.btn_lihat);

        etJudul = findViewById(R.id.et_judul);
        etNote = findViewById(R.id.et_note);

        appDatabase = AppDatabase.iniDB(getApplicationContext());

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
                Intent intent = new Intent(getApplicationContext(), LihatDataActivity.class);

                startActivity(intent);

            }
        });

    }
}