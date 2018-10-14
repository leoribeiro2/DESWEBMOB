package br.com.leoribeiorweb.pipocaccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner genreSpiner;
    public static final String KEY = "br.com.leoribeiroweb.pipoca";
    String genre = "Todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genreSpiner = findViewById(R.id.genreSpinner);
        genreSpiner.setOnItemSelectedListener(new FilmSelected());
    }

    public void listFilms(View view) {
        Intent intent = new Intent(this, ListFilmsActivity.class);

        intent.putExtra(KEY, genre);
        startActivity(intent);
    }

    private class FilmSelected implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genre = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
