/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

import br.com.leoribeiorweb.pipocaccp3anbua.model.Genre;
import br.com.leoribeiorweb.pipocaccp3anbua.model.GenreResponse;
import br.com.leoribeiorweb.pipocaccp3anbua.service.TMDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Spinner genreSpiner;
    public static final String KEY = "br.com.leoribeiroweb.pipoca";
    List<String> genres;
    List<Genre> genreList;
    String selectedGenre = "28";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TMDBService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService tmdbService = retrofit.create(TMDBService.class);


        String language = "pt-BR";

        Call<GenreResponse> call = tmdbService.listGenres(TMDBService.apiKey, language);
        call.enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                genreList = response.body().getGenres();
                genres = genreList.stream().map(genre -> genre.getName()).collect(Collectors.toList());
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, genres);
                genreSpiner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        genreSpiner = findViewById(R.id.genreSpinner);
        genreSpiner.setOnItemSelectedListener(new FilmSelected());
    }

    public void listFilms(View view) {
        Intent intent = new Intent(this, ListFilmsActivity.class);

        intent.putExtra(KEY, selectedGenre);
        startActivity(intent);
    }

    private class FilmSelected implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selected = (String) parent.getItemAtPosition(position);
            selectedGenre = genreList.stream().filter(genre -> genre.getName() == selected)
                    .collect(Collectors.toList()).get(0).getId().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
