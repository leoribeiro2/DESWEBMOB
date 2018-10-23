package br.com.leoribeiorweb.pipocaccp3anbua;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerAPI implements Callback<List<Film>> {
    static final String BASE_URL = "";

    public void getFilms() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PipocaAPI pipocaAPI = retrofit.create(PipocaAPI.class);

        Call<List<Film>> call = pipocaAPI.loadFilms()
    }
}
