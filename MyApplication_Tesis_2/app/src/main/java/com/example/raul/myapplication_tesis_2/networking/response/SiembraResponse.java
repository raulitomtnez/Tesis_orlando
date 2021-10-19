
package com.example.raul.myapplication_tesis_2.networking.response;

import java.util.List;

import com.example.raul.myapplication_tesis_2.networking.model.IdCentro;
import com.example.raul.myapplication_tesis_2.networking.model.IdClase;
import com.example.raul.myapplication_tesis_2.networking.model.IdTipoCultivo;
import com.example.raul.myapplication_tesis_2.networking.model.IdTipoSiembra;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SiembraResponse {

    @SerializedName("fechaSiembra")
    @Expose
    private String fechaSiembra;
    @SerializedName("pesoLarva")
    @Expose
    private Double pesoLarva;
    @SerializedName("estadioLarval")
    @Expose
    private String estadioLarval;
    @SerializedName("idClase")
    @Expose
    private IdClase idClase;
    @SerializedName("idTipoCultivo")
    @Expose
    private IdTipoCultivo idTipoCultivo;
    @SerializedName("idTipoSiembra")
    @Expose
    private IdTipoSiembra idTipoSiembra;
    @SerializedName("idCentro")
    @Expose
    private List<IdCentro> idCentro ;

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public Double getPesoLarva() {
        return pesoLarva;
    }

    public void setPesoLarva(Double pesoLarva) {
        this.pesoLarva = pesoLarva;
    }

    public String getEstadioLarval() {
        return estadioLarval;
    }

    public void setEstadioLarval(String estadioLarval) {
        this.estadioLarval = estadioLarval;
    }

    public IdClase getIdClase() {
        return idClase;
    }

    public void setIdClase(IdClase idClase) {
        this.idClase = idClase;
    }

    public IdTipoCultivo getIdTipoCultivo() {
        return idTipoCultivo;
    }

    public void setIdTipoCultivo(IdTipoCultivo idTipoCultivo) {
        this.idTipoCultivo = idTipoCultivo;
    }

    public IdTipoSiembra getIdTipoSiembra() {
        return idTipoSiembra;
    }

    public void setIdTipoSiembra(IdTipoSiembra idTipoSiembra) {
        this.idTipoSiembra = idTipoSiembra;
    }

    public List<IdCentro> getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(List<IdCentro> idCentro) {
        this.idCentro = idCentro;
    }

}
