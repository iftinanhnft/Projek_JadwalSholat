package com.example.jadwal_sholat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwal_sholat.R;
import com.example.jadwal_sholat.model.waktusholat.DataItem;
import com.example.jadwal_sholat.view.activity.JadwalDetail;

import java.util.ArrayList;

public class WaktuSholatAdapter extends RecyclerView.Adapter<WaktuSholatAdapter.ViewHolder> {

    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public WaktuSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WaktuSholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaktuSholatAdapter.ViewHolder holder, int position) {
        holder.tanggal.setText(dataItems.get(position).getDate().getReadable());
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JadwalDetail.class);
                intent.putExtra("dImsak", dataItems.get(position).getTimings().getImsak());
                //intent.putExtra("dSubuh", dataItems.get(position).getTimings().getImsak());
                intent.putExtra("dDhuhur", dataItems.get(position).getTimings().getDhuhr());
                intent.putExtra("dAsr", dataItems.get(position).getTimings().getAsr());
                intent.putExtra("dMaghrib", dataItems.get(position).getTimings().getMaghrib());
                intent.putExtra("dIsha", dataItems.get(position).getTimings().getIsha());
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tanggal = itemView.findViewById(R.id.txt_tanggal_masehi);

        }
    }
}
