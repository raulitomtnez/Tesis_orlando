package com.example.raul.myapplication_tesis_2.networking.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Raul on 14/1/2021.
 */

public class User {

    @SerializedName("username")
    private String username;

    @SerializedName("roles")
    private List<String> roles = null;

    @SerializedName("nombreCompleto")
    private String nombreCompleto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
