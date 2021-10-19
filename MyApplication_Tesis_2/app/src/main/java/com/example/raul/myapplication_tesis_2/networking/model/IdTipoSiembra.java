
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdTipoSiembra {

    @SerializedName("nombreTipoSiembra")
    @Expose
    private String nombreTipoSiembra;

    public String getNombreTipoSiembra() {
        return nombreTipoSiembra;
    }

    public void setNombreTipoSiembra(String nombreTipoSiembra) {
        this.nombreTipoSiembra = nombreTipoSiembra;
    }

}
