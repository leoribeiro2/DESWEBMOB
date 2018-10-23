package br.com.leoribeiorweb.agendacomfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.leoribeiorweb.agendacomfirebase.model.Contato;

/*
 * Author: Leonardo Ribeiro
 * RA: 816119319
 * */
public class ListaDeContatosActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference contatosReference;
    private void configuraDatabase (){
        firebaseDatabase = FirebaseDatabase.getInstance();
        contatosReference = firebaseDatabase.getReference("contatos");
    }

    private List<Contato> contatos;

    private ArrayAdapter<Contato> contatosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_contatos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView contatosListView = findViewById(R.id.contatosListView);

        configuraDatabase();

        contatos = new ArrayList<>();
        contatosAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contatos
        );

        contatosListView.setAdapter(contatosAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(
                        ListaDeContatosActivity.this,
                        AdicionaContatoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        contatosReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                contatos.clear();
                for (DataSnapshot json : dataSnapshot.getChildren()) {
                    Contato contato = json.getValue(Contato.class);
                    contato.setId(json.getKey());
                    contatos.add(contato);
                }
                contatosAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ListaDeContatosActivity.this,
                        getString(R.string.erro_firebase),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
