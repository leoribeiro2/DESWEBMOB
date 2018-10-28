/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.leoribeiorweb.pipocaccp3anbua.model.Film;

public class FilmDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);
        TextView releaseDate = findViewById(R.id.releaseDate);
        ImageView imageView = findViewById(R.id.film_image);

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra(ListFilmsActivity.KEY);
        name.setText(film.getTitle());
        description.setText(film.getOverview());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String[] dateParts = film.getReleaseDate().split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
        releaseDate.setText(date.format(formatter));
        Picasso.get().load("https://image.tmdb.org/t/p/w500" + film.getBackdropPath()).into(imageView);
    }
}
