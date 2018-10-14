package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FilmDetailsActivity extends AppCompatActivity {
    TextView txtFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        txtFilm = findViewById(R.id.txtFilm);
        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra(ListFilmsActivity.KEY);

        txtFilm.setText(film.toString());
    }
}
