
package com.example.raul.myapplication_tesis_2.networking.response;

import com.example.raul.myapplication_tesis_2.networking.model.CiCamaronicultor;
import com.example.raul.myapplication_tesis_2.networking.model.IdGranja;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstanqueResponse {

    @SerializedName("numero")
    @Expose
    private Integer numero;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("ciCamaronicultor")
    @Expose
    private CiCamaronicultor ciCamaronicultor;
    @SerializedName("idGranja")
    @Expose
    private IdGranja idGranja;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public CiCamaronicultor getCiCamaronicultor() {
        return ciCamaronicultor;
    }

    public void setCiCamaronicultor(CiCamaronicultor ciCamaronicultor) {
        this.ciCamaronicultor = ciCamaronicultor;
    }

    public IdGranja getIdGranja() {
        return idGranja;
    }

    public void setIdGranja(IdGranja idGranja) {
        this.idGranja = idGranja;
    }

}
