package com.example.raul.myapplication_tesis_2.networking.response;

import com.example.raul.myapplication_tesis_2.networking.model.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}