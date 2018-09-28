package br.com.leoribeiorweb.paisesccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Author: Leonardo Ribeiro Guimarães
 * RA: 816119319
 */
public class MainActivity extends AppCompatActivity {
    Spinner spinnerContinente;
    String continente = "Todos";

    public static final String EXTRA_CONTINENTE = "br.com.leoribeiorweb.CONTINENTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new PaisSelecionado());
    }

    public void listarPaises(View view){
        Intent intent = new Intent(this, ListaPaisesActivity.class);
        intent.putExtra(EXTRA_CONTINENTE, continente);
        startActivity(intent);
    }

    private class PaisSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
