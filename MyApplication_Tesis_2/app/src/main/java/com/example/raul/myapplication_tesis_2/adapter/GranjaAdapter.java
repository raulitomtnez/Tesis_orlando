package com.example.raul.myapplication_tesis_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.networking.response.GranjaResponse;

import java.util.ArrayList;
import java.util.List;

public class GranjaAdapter extends RecyclerView.Adapter<GranjaAdapter.GranjaViewHolder> {
    // data
    private List<GranjaResponse> itemList = new ArrayList<>();


    public GranjaAdapter(List<GranjaResponse> itemList) {
        this.itemList = itemList;
    }

    @Override
    public GranjaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_granja, parent, false);
        return new GranjaViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(GranjaViewHolder holder, int position) {
        // get data
        GranjaResponse item = itemList.get(position);


        String nombreGranja = item.getNombre();
        String ciJefe1 = item.getCiJefe1().getCi();
        String nombreJefe1 = item.getCiJefe1().getNombres();
        String ApellidosJefe1 = item.getCiJefe1().getApellidos();
        String nombreUebjefe1 = item.getIdUeb().getNombreUeb();
        String ciJefe2 = item.getCiJefe1().getCi();
        String nombreJefe2 = item.getCiJefe2().getNombres();
        String apellidosJefe2 = item.getCiJefe2().getApellidos();
        String nombreUebJefe2 = item.getIdUeb().getNombreUeb();
        String nombreUeb = item.getIdUeb().getNombreUeb();


        // set data
        holder.tvnombreGranja.setText(" Nombre Granja: " + " " + nombreGranja);
        holder.tvciJefe1.setText("Carnet Identidad del Primer jefe: " + " " + ciJefe1);
        holder.tvnombreJefe1.setText("Nombre: " + " " + nombreJefe1);
        holder.tvapellidoJefe1.setText(" Apellidos: " + " " + ApellidosJefe1);
        holder.tvnombreUebradica.setText(" Nombre Ueb donde Radica: " + " " + nombreUebjefe1);
        holder.tvciJefe2.setText(" Carnet de Identidad del Segundo Jefe : " + " " + ciJefe2);
        holder.tvnombreJefe2.setText(" Nombre : " + " " + nombreJefe2);
        holder.tvapellidoJefe2.setText(" Apellidos : " + " " + apellidosJefe2);
        holder.tvnombreUebRadicaJefe2.setText(" Nombre de Ueb donde Radica : " + " " + nombreUebJefe2);
        holder.tvUebGranja.setText(" Nombre de Ueb donde se esta Trabajando : " + " " + nombreUeb);

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
    public void setItems(List<GranjaResponse> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder inner class
     */
    class GranjaViewHolder extends RecyclerView.ViewHolder {
        // UI
        TextView tvnombreGranja;
        TextView tvciJefe1;
        TextView tvnombreJefe1;
        TextView tvapellidoJefe1;
        TextView tvnombreUebradica;
        TextView tvciJefe2;
        TextView tvnombreJefe2;
        TextView tvapellidoJefe2;
        TextView tvnombreUebRadicaJefe2;
        TextView tvUebGranja;

        GranjaViewHolder(View itemView) {
            super(itemView);
            tvnombreGranja = (TextView) itemView.findViewById(R.id.tv_nombreGranja);
            tvciJefe1 = (TextView) itemView.findViewById(R.id.tv_ciJefe1);
            tvnombreJefe1 = (TextView) itemView.findViewById(R.id.tv_nombreJefe1);
            tvapellidoJefe1 = (TextView) itemView.findViewById(R.id.tv_apellidoJefe1);
            tvnombreUebradica = (TextView) itemView.findViewById(R.id.tv_nombreUebsJefe1);
            tvciJefe2 = (TextView) itemView.findViewById(R.id.tv_ciJefe2);
            tvnombreJefe2 = (TextView) itemView.findViewById(R.id.tv_nombrejefe2);
            tvapellidoJefe2 = (TextView) itemView.findViewById(R.id.tv_apellidosJefe2);
            tvnombreUebRadicaJefe2 = (TextView) itemView.findViewById(R.id.tv_nombreUebsJefe2);
            tvUebGranja = (TextView) itemView.findViewById(R.id.tv_nombreUbs);

        }
    }
}
