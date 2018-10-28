/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua.service;

import java.util.List;

import br.com.leoribeiorweb.pipocaccp3anbua.model.FilmListReponse;
import br.com.leoribeiorweb.pipocaccp3anbua.model.Genre;
import br.com.leoribeiorweb.pipocaccp3anbua.model.GenreResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBService {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String apiKey = "e0b04a83bf16ee6c19fd2e31bda50298";

    @GET("genre/movie/list")
    Call<GenreResponse> listGenres(@Query("api_key") String apiKey,
                                   @Query("language") String language);

    @GET("discover/movie")
    Call<FilmListReponse> listFilms(@Query("api_key") String apiKey,
                                    @Query("language") String language,
                                    @Query("sort_by") String sort,
                                    @Query("include_video") Boolean adult,
                                    @Query("with_genres") String genre);
}
