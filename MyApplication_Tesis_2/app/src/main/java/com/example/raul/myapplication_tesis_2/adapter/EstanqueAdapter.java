package com.example.raul.myapplication_tesis_2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.networking.response.EstanqueResponse;

import java.util.ArrayList;
import java.util.List;

public class EstanqueAdapter extends RecyclerView.Adapter<EstanqueAdapter.EstanqueViewHolder> {
    // data
    private List<EstanqueResponse> itemList = new ArrayList<>();


    public EstanqueAdapter(List<EstanqueResponse> itemList) {
        this.itemList = itemList;
    }

    @Override
    public EstanqueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estanque, parent, false);
        return new EstanqueViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(EstanqueViewHolder holder, int position) {
        // get data
        EstanqueResponse item = itemList.get(position);


        String numero = item.getNumero().toString();
        String area = item.getArea().toString();
        String ciCamaronicultor = item.getCiCamaronicultor().getCi();
        String nombreCamaronicultor = item.getCiCamaronicultor().getNombres();
        String apellidosCamaronicultor = item.getCiCamaronicultor().getApellidos();
        String idGranja = item.getIdGranja().getNombre();



        // set data
        holder.tvnumeroEstanque.setText(" Numero estanque: " + " " + numero);
        holder.tvAreaEstanque.setText("Area Estanque: " + " " + area);
        holder.tvciCamaronicultor.setText(" Carnet Identidad Camaronicultor: " + " " + ciCamaronicultor);
        holder.tvnombreCamaronicultor.setText(" nombre de Camaronicultor: " + " " + nombreCamaronicultor);
        holder.tvapellidosCamaronicultor.setText(" Apellidos de Camaronicultor: " + " " + apellidosCamaronicultor);
        holder.tvNombreGranja.setText(" nombre Granja: " + " " + idGranja);

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
    public void setItems(List<EstanqueResponse> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }


    /**
     * ViewHolder inner class
     */
    class EstanqueViewHolder extends RecyclerView.ViewHolder {
        // UI
        TextView tvnumeroEstanque;
        TextView tvAreaEstanque;
        TextView tvciCamaronicultor;
        TextView tvnombreCamaronicultor;
        TextView tvapellidosCamaronicultor;
        TextView tvNombreGranja;




        EstanqueViewHolder(View itemView) {
            super(itemView);
            tvnumeroEstanque = (TextView) itemView.findViewById(R.id.tv_numero_estanque);
            tvAreaEstanque = (TextView) itemView.findViewById(R.id.tv_areaEstanque);
            tvciCamaronicultor = (TextView) itemView.findViewById(R.id.tv_ciCamaronicultor);
            tvnombreCamaronicultor = (TextView) itemView.findViewById(R.id.tv_nombreCamaronicultor);
            tvapellidosCamaronicultor = (TextView) itemView.findViewById(R.id.tv_apellidos);
            tvNombreGranja = (TextView) itemView.findViewById(R.id.tv_idGranja);

        }
    }
}
