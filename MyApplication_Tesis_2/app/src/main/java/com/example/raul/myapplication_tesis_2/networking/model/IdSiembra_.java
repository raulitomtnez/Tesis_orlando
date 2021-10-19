
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdSiembra_ {

    @SerializedName("idEstanque")
    @Expose
    private IdEstanque idEstanque;

    public IdEstanque getIdEstanque() {
        return idEstanque;
    }

    public void setIdEstanque(IdEstanque idEstanque) {
        this.idEstanque = idEstanque;
    }

}
