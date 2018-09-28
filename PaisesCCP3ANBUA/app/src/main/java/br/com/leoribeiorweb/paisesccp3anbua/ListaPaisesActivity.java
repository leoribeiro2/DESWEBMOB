package br.com.leoribeiorweb.paisesccp3anbua;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaPaisesActivity extends AppCompatActivity {

    public static final String EXTRA_PAIS = "br.com.leoribeiroweb.PAIS";

    Activity activity;
    ArrayList<Pais> paises;
    ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        activity = this;
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.EXTRA_CONTINENTE);
        paises = Data.listarPaises(continente);
        nomes = Data.listarNomes(paises);

        ListView listView = findViewById(R.id.lista_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(activity, DetalhePaisActivity.class);
                intent.putExtra(EXTRA_PAIS, paises.get(position));

                startActivity(intent);

            }

        });
    }

    private ArrayList<String> geraListaPaises() {
        return null;
    }
}
