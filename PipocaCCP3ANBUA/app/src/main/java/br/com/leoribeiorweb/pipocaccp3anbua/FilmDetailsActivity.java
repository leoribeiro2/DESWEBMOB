package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilmDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        TextView name = findViewById(R.id.name);
        TextView director = findViewById(R.id.director);
        TextView description = findViewById(R.id.description);
        TextView releaseDate = findViewById(R.id.releaseDate);

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra(ListFilmsActivity.KEY);
        name.setText(film.getName());
        director.setText(film.getDirector());
        description.setText(film.getDescription());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate date = film.getReleaseDate();
        releaseDate.setText(date.format(formatter));
    }
}
