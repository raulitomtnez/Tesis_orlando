
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdTipoPienso {

    @SerializedName("nombreTipoPienso")
    @Expose
    private String nombreTipoPienso;

    public String getNombreTipoPienso() {
        return nombreTipoPienso;
    }

    public void setNombreTipoPienso(String nombreTipoPienso) {
        this.nombreTipoPienso = nombreTipoPienso;
    }

}
