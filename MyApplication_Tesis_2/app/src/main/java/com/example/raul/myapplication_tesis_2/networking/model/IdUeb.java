
package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdUeb {

    @SerializedName("nombreUeb")
    @Expose
    private String nombreUeb;

    public String getNombreUeb() {
        return nombreUeb;
    }

    public void setNombreUeb(String nombreUeb) {
        this.nombreUeb = nombreUeb;
    }

}
