
package com.example.raul.myapplication_tesis_2.networking.response;

import com.example.raul.myapplication_tesis_2.networking.model.CiJefe1;
import com.example.raul.myapplication_tesis_2.networking.model.CiJefe2;
import com.example.raul.myapplication_tesis_2.networking.model.IdUeb__;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GranjaResponse {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("ciJefe1")
    @Expose
    private CiJefe1 ciJefe1;
    @SerializedName("ciJefe2")
    @Expose
    private CiJefe2 ciJefe2;
    @SerializedName("idUeb")
    @Expose
    private IdUeb__ idUeb;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CiJefe1 getCiJefe1() {
        return ciJefe1;
    }

    public void setCiJefe1(CiJefe1 ciJefe1) {
        this.ciJefe1 = ciJefe1;
    }

    public CiJefe2 getCiJefe2() {
        return ciJefe2;
    }

    public void setCiJefe2(CiJefe2 ciJefe2) {
        this.ciJefe2 = ciJefe2;
    }

    public IdUeb__ getIdUeb() {
        return idUeb;
    }

    public void setIdUeb(IdUeb__ idUeb) {
        this.idUeb = idUeb;
    }

}
