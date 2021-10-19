package com.example.raul.myapplication_tesis_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.networking.model.UEB;

import java.util.ArrayList;
import java.util.List;

public class UEBAdapter extends RecyclerView.Adapter<UEBAdapter.UEBViewHolder> {
    // data
    private List<UEB> itemList = new ArrayList<>();

    public UEBAdapter(List<UEB> itemList) {
        this.itemList = itemList;
    }

    @Override
    public UEBViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ueb, parent, false);
        return new UEBViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(UEBViewHolder holder, int position) {
        // get data
        UEB ueb = itemList.get(position);
        String uebName = ueb.getNombreUeb();

        // set data
        holder.tvUEBName.setText("nombre Ueb: " + " " + uebName);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * set uebs
     *
     * @param uebs list of Notes
     */
    public void setUEBs(List<UEB> uebs) {
        this.itemList = uebs;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder inner class
     */
    class UEBViewHolder extends RecyclerView.ViewHolder {
        // UI
        TextView tvUEBName;

        UEBViewHolder(View itemView) {
            super(itemView);
            tvUEBName = (TextView) itemView.findViewById(R.id.tv_name_ueb);

        }
    }
}
