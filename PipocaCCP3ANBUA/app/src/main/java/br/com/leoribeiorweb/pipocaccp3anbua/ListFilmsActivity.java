package br.com.leoribeiorweb.pipocaccp3anbua;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/*
 * Author: Leonardo Ribeiro
 * RA: 816119319
 * */
public class ListFilmsActivity extends AppCompatActivity {
    public static final String KEY = "br.com.leoribeiroweb.pipoca";
    Activity activity;
    ArrayList<Film> films;
    ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_films);
        activity = this;
        Intent intent = getIntent();
        String genre = intent.getStringExtra(MainActivity.KEY);
        films = Data.listFilms(genre);
        names = Data.listNames(films);

        ListView listView = findViewById(R.id.list_films);
        FilmAdapter adapter = new FilmAdapter(this, films);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, FilmDetailsActivity.class);
                intent.putExtra(KEY, films.get(position));

                startActivity(intent);
            }
        });
    }
}
