
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdSiembra {

    @SerializedName("fechaSiembra")
    @Expose
    private String fechaSiembra;
    @SerializedName("idSiembra")
    @Expose
    private IdSiembra_ idSiembra;


    @SerializedName("idEstanque")
    @Expose
    private IdEstanque idEstanque;




    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public IdSiembra_ getIdSiembra() {
        return idSiembra;
    }

    public void setIdSiembra(IdSiembra_ idSiembra) {
        this.idSiembra = idSiembra;
    }

}
