/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.leoribeiorweb.pipocaccp3anbua.model.Film;
import br.com.leoribeiorweb.pipocaccp3anbua.model.FilmListReponse;
import br.com.leoribeiorweb.pipocaccp3anbua.service.TMDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFilmsActivity extends AppCompatActivity {
    public static final String KEY = "br.com.leoribeiroweb.pipoca";
    Activity activity;
    List<Film> films;
    ArrayList<String> names;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_films);
        activity = this;
        Intent intent = getIntent();
        String genreId = intent.getStringExtra(MainActivity.KEY);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TMDBService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TMDBService tmdbService = retrofit.create(TMDBService.class);

        Call<FilmListReponse> call = tmdbService.listFilms(
                TMDBService.apiKey,
                "pt-BR",
                "popularity.desc",
                false,
                genreId
        );

        call.enqueue(new Callback<FilmListReponse>() {
            @Override
            public void onResponse(Call<FilmListReponse> call, Response<FilmListReponse> response) {
                films = response.body().getResults();
                listView = findViewById(R.id.list_films);
                FilmAdapter adapter = new FilmAdapter(getApplicationContext(), films);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener((parent, view, position, id) -> {
                    Intent intent1 = new Intent(activity, FilmDetailsActivity.class);
                    intent1.putExtra(KEY, (Serializable) films.get(position));

                    startActivity(intent1);
                });
            }

            @Override
            public void onFailure(Call<FilmListReponse> call, Throwable t) {
                Toast.makeText(ListFilmsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}
