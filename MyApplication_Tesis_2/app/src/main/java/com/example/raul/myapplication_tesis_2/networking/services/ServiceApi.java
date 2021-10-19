package com.example.raul.myapplication_tesis_2.networking.services;


import com.example.raul.myapplication_tesis_2.networking.model.UEB;
import com.example.raul.myapplication_tesis_2.networking.response.AlimentacionResponse;
import com.example.raul.myapplication_tesis_2.networking.response.EstanqueResponse;
import com.example.raul.myapplication_tesis_2.networking.response.GranjaResponse;
import com.example.raul.myapplication_tesis_2.networking.response.LoginRequest;
import com.example.raul.myapplication_tesis_2.networking.response.LoginResponse;
import com.example.raul.myapplication_tesis_2.networking.response.SiembraResponse;
import com.example.raul.myapplication_tesis_2.networking.routes.Routes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST(Routes.LOGIN)
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET(Routes.UEB)
    Call<List<UEB>> getUEBS();

    @GET(Routes.SIEMBRA)
    Call<List<SiembraResponse>> getSiembras();

    @GET(Routes.Estanque)
    Call<List<EstanqueResponse>> getEstanques();

    @GET(Routes.Alimentacions)
    Call<List<AlimentacionResponse>> getAlimentacions();

    @GET(Routes.Granjas)
    Call<List<GranjaResponse>> getGranjas();
}
