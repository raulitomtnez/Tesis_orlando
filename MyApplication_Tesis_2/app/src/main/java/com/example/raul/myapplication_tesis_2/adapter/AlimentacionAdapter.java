package com.example.raul.myapplication_tesis_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.networking.response.AlimentacionResponse;

import java.util.ArrayList;
import java.util.List;

public class AlimentacionAdapter extends RecyclerView.Adapter<AlimentacionAdapter.AlimentacionViewHolder> {
    // data
    private List<AlimentacionResponse> itemList = new ArrayList<>();


    public AlimentacionAdapter(List<AlimentacionResponse> itemList) {
        this.itemList = itemList;
    }

    @Override
    public AlimentacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alimentacion, parent, false);
        return new AlimentacionViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(AlimentacionViewHolder holder, int position) {
        // get data
        AlimentacionResponse item = itemList.get(position);


        String fecha = getDateFormated(item.getFecha());
        String ses1 = String.valueOf(item.getSesionManana1());
        String ses2 = String.valueOf(item.getSesionManana2());

        String sest1 = item.getSesionTarde1() != null ? String.valueOf(item.getSesionTarde1()) : "--";
        String sest2 = String.valueOf(item.getSesionTarde2());
        String observaciones = item.getObservaciones();
        String fechaSembra = getDateFormated(item.getIdSiembra().getFechaSiembra());
        String numeroEstanque = item.getIdSiembra().getIdSiembra().getIdEstanque().getNumero().toString();
        String nombreTipoPienso = item.getIdTipoPienso().getNombreTipoPienso();


        // set data
        holder.tvFechaAlimentacion.setText(" Fecha alimentacion: " + " " + fecha);
        holder.tvsesion1.setText("Sesion mañana: " + " " + ses1);
        holder.tvsesion2.setText("Sesion mañana dos: " + " " + ses2);
        holder.tvsesiontarde1.setText(" Sesion tarde: " + " " + sest1);
        holder.tvsesiontarde2.setText(" Sesion tarde dos: " + " " + sest2);
        holder.tvObservacion.setText(" Observaciones : " + " " + observaciones);
        holder.tvFechaSiembra.setText(" Fecha Siembra : " + " " + fechaSembra);
        holder.tvNumeroEstanque.setText(" Numero Estanque : " + " " + numeroEstanque);
        holder.tvNombreTipoPienso.setText(" nombre Tipo de Pienso : " + " " + nombreTipoPienso);

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
    public void setItems(List<AlimentacionResponse> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder inner class
     */
    class AlimentacionViewHolder extends RecyclerView.ViewHolder {
        // UI
        TextView tvFechaAlimentacion;
        TextView tvsesion1;
        TextView tvsesion2;
        TextView tvsesiontarde1;
        TextView tvsesiontarde2;
        TextView tvObservacion;
        TextView tvFechaSiembra;
        TextView tvNumeroEstanque;
        TextView tvNombreTipoPienso;


        AlimentacionViewHolder(View itemView) {
            super(itemView);
            tvFechaAlimentacion = (TextView) itemView.findViewById(R.id.tv_fechaAlimentacion);
            tvsesion1 = (TextView) itemView.findViewById(R.id.tv_sesionManana1);
            tvsesion2 = (TextView) itemView.findViewById(R.id.tv_sesionManana2);
            tvsesiontarde1 = (TextView) itemView.findViewById(R.id.tv_sesiontarde1);
            tvsesiontarde2 = (TextView) itemView.findViewById(R.id.tv_sesiontarde2);
            tvObservacion = (TextView) itemView.findViewById(R.id.tv_observaciones);
            tvFechaSiembra = (TextView) itemView.findViewById(R.id.tv_idFechaSiembra);
            tvNumeroEstanque = (TextView) itemView.findViewById(R.id.tv_idNumero_estanque);
            tvNombreTipoPienso = (TextView) itemView.findViewById(R.id.tv_idTipoPienso);

        }
    }
}
