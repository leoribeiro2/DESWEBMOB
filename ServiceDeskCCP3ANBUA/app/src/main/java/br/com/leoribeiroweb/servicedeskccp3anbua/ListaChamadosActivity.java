package br.com.leoribeiroweb.servicedeskccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.leoribeiroweb.servicedeskccp3anbua.adpater.ChamadosAdapter;
import br.com.leoribeiroweb.servicedeskccp3anbua.model.Chamado;

import static br.com.leoribeiroweb.servicedeskccp3anbua.MainActivity.NOME_FILA;

public class ListaChamadosActivity extends AppCompatActivity {

    private ListView listView;
    private List<Chamado> chamados;
    private ChamadosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        listView = findViewById(R.id.listView);
        chamados = new ArrayList<>();
        adapter = new ChamadosAdapter(chamados, this);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        String valor = intent.getStringExtra(NOME_FILA);
        chamados.addAll(buscaChamados(valor));
        adapter.notifyDataSetChanged();
        ListView.OnItemClickListener itemClickListener = (parent, view, position, id) -> {
            Chamado oCaraQueFoiTocado = chamados.get(position);
            Intent detalhesIntent = new Intent(this, DetalhesActivity.class);
            detalhesIntent.putExtra("oCaraQueFoiTocado", oCaraQueFoiTocado);
            startActivity(detalhesIntent);
        };
        listView.setOnItemClickListener(itemClickListener);
    }

    public ArrayList<Chamado> buscaChamados(String chave){
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Chamado> subLista = new ArrayList<>();
            for(Chamado chamado:lista){
                if(chamado.getNome().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(chamado);
                }
            }
            return subLista;
        }
    }

    public ArrayList<Chamado> geraListaChamados() {
        ArrayList<Chamado> lista = new ArrayList<>();
        lista.add(new Chamado("Desktops", "Computador da secretária quebrado."));
        lista.add(new Chamado ("Telefonia" , "Telefone não funciona."));
        lista.add(new Chamado ("Redes", "Manutenção no proxy"));
        lista.add(new Chamado ("Servidores", "Lentidão generalizada"));
        return lista;
    }
}
