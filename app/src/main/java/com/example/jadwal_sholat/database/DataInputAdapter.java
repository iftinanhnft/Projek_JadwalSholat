package com.example.jadwal_sholat.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwal_sholat.R;

import java.util.ArrayList;

public class DataInputAdapter extends RecyclerView.Adapter<DataInputAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DataInput> datainputItem = new ArrayList<>();
    private AppDatabase appDatabase;

    public DataInputAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.iniDB(this.context);

    }

    public void setDatainputItem(ArrayList<DataInput> items) {
        datainputItem.clear();
        datainputItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lihat_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataInputAdapter.ViewHolder holder, int position) {
        holder.tvJudul.setText(datainputItem.get(position).getJudul());
        holder.tvNote.setText(datainputItem.get(position).getNote());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataInput dataInput = new DataInput();

                dataInput.setId(datainputItem.get(position).getId());
                dataInput.setJudul(datainputItem.get(position).getJudul());
                dataInput.setNote(datainputItem.get(position).getNote());

                appDatabase.dao().deletedata(dataInput);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datainputItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnDelete;
        TextView tvJudul, tvNote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btnDelete = itemView.findViewById(R.id.btn_hapus);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvNote = itemView.findViewById(R.id.tv_note);
        }
    }
}
