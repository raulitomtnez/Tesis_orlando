
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdTipoCultivo {

    @SerializedName("nombreTipoCultivo")
    @Expose
    private String nombreTipoCultivo;

    public String getNombreTipoCultivo() {
        return nombreTipoCultivo;
    }

    public void setNombreTipoCultivo(String nombreTipoCultivo) {
        this.nombreTipoCultivo = nombreTipoCultivo;
    }

}
