
package com.example.raul.myapplication_tesis_2.networking.response;

import com.example.raul.myapplication_tesis_2.networking.model.IdSiembra;
import com.example.raul.myapplication_tesis_2.networking.model.IdTipoPienso;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlimentacionResponse {

    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("sesionManana1")
    @Expose
    private Integer sesionManana1;
    @SerializedName("sesionManana2")
    @Expose
    private Integer sesionManana2;
    @SerializedName("sesionTarde1")
    @Expose
    private Integer sesionTarde1;
    @SerializedName("sesionTarde2")
    @Expose
    private Integer sesionTarde2;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    @SerializedName("idSiembra")
    @Expose
    private IdSiembra idSiembra;
    @SerializedName("idTipoPienso")
    @Expose
    private IdTipoPienso idTipoPienso;



    public AlimentacionResponse() {

    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getSesionManana1() {
        return sesionManana1;
    }

    public void setSesionManana1(Integer sesionManana1) {
        this.sesionManana1 = sesionManana1;
    }

    public Integer getSesionManana2() {
        return sesionManana2;
    }

    public void setSesionManana2(Integer sesionManana2) {
        this.sesionManana2 = sesionManana2;
    }

    public Integer getSesionTarde1() {
        return sesionTarde1;
    }

    public void setSesionTarde1(Integer sesionTarde1) {
        this.sesionTarde1 = sesionTarde1;
    }

    public Integer getSesionTarde2() {
        return sesionTarde2;
    }

    public void setSesionTarde2(Integer sesionTarde2) {
        this.sesionTarde2 = sesionTarde2;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public IdSiembra getIdSiembra() {
        return idSiembra;
    }

    public void setIdSiembra(IdSiembra idSiembra) {
        this.idSiembra = idSiembra;
    }

    public IdTipoPienso getIdTipoPienso() {
        return idTipoPienso;
    }

    public void setIdTipoPienso(IdTipoPienso idTipoPienso) {
        this.idTipoPienso = idTipoPienso;
    }

}
