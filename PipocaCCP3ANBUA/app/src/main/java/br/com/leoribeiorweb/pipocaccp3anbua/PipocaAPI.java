package br.com.leoribeiorweb.pipocaccp3anbua;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PipocaAPI {

    @GET("/films")
    Call<List<Film>> loadFilms(@Query("genre") String genre);
}
