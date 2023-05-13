package com.svalero.aasfrpm.api;

import static com.svalero.aasfrpm.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeLoVendoApi {
    public static TeLoVendoApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TeLoVendoApiInterface.class);
    }
}
