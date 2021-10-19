package com.example.raul.myapplication_tesis_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.networking.response.SiembraResponse;

import java.util.ArrayList;
import java.util.List;

public class SiembraAdapter extends RecyclerView.Adapter<SiembraAdapter.SiembraViewHolder> {
    // data
    private List<SiembraResponse> itemList = new ArrayList<>();

    public SiembraAdapter(List<SiembraResponse> itemList) {
        this.itemList = itemList;
    }

    @Override
    public SiembraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_siembra, parent, false);
        return new SiembraViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(SiembraViewHolder holder, int position) {
        // get data
        SiembraResponse item = itemList.get(position);


        String fechaSiembra = getDateFormated(item.getFechaSiembra());
        String pesoLarva = item.getPesoLarva().toString();
        String estadioLarval = item.getEstadioLarval();
        String idClase = item.getIdClase().getNombreClase();
        String idTipoCultivo = item.getIdTipoCultivo().getNombreTipoCultivo();
        String idTipoSiembra = item.getIdTipoSiembra().getNombreTipoSiembra();
        String idcentro = item.getIdCentro().get(0).getNombreCentro();

        // set data
        holder.tvFechaSiembra.setText(" Fecha Siembra : " + " " + fechaSiembra);
        holder.tvpesoLarva.setText(" Peso larval: " + " " + pesoLarva);
        holder.tvEstadioLarval.setText(" Estadio Larval: " + " " + estadioLarval);
        holder.tvIdClase.setText(" nombre de CLase: " + " " + idClase);
        holder.tvIdTipoCultivo.setText(" nombre Cultivo : " + " " + idTipoCultivo);
        holder.tvIdTipoSiembra.setText(" nombre siembra : " + " " + idTipoSiembra);
        holder.tvIdCentro.setText(" nombre Centro : " + " " + idcentro);


    }

    private String getDateFormated(String date) {
        String year = "" + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
        String month = "" + date.charAt(5) + date.charAt(6);
        String day = "" + date.charAt(8) + date.charAt(9);

        return day + "/" + month + "/" + year;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /**
     * set items
     *
     * @param items list of Notes
     */
    public void setItems(List<SiembraResponse> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder inner class
     */
    class SiembraViewHolder extends RecyclerView.ViewHolder {
        // UI
        TextView tvFechaSiembra;
        TextView tvpesoLarva;
        TextView tvEstadioLarval;
        TextView tvIdClase;
        TextView tvIdTipoCultivo;
        TextView tvIdTipoSiembra;
        TextView tvIdCentro;




        SiembraViewHolder(View itemView) {
            super(itemView);
            tvFechaSiembra = (TextView) itemView.findViewById(R.id.tv_fechaSiembra);
            tvpesoLarva = (TextView) itemView.findViewById(R.id.tv_pesoLarva);
            tvEstadioLarval = (TextView) itemView.findViewById(R.id.tv_estadioLarval);
            tvIdClase = (TextView) itemView.findViewById(R.id.tv_idClase);
            tvIdTipoCultivo = (TextView) itemView.findViewById(R.id.tv_idTipoCultivo);
            tvIdTipoSiembra = (TextView) itemView.findViewById(R.id.tv_idTipoSiembra);
            tvIdCentro = (TextView) itemView.findViewById(R.id.tv_idCentro);


        }
    }
}
