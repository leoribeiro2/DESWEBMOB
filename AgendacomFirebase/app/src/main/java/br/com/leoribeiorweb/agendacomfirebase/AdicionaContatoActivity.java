package br.com.leoribeiorweb.agendacomfirebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.leoribeiorweb.agendacomfirebase.model.Contato;

/*
 * Author: Leonardo Ribeiro
 * RA: 816119319
 * */
public class AdicionaContatoActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference contatosReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_contato);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText nomeEditText;
        final EditText foneEditText;
        final EditText emailEditText;

        nomeEditText = findViewById(R.id.nomeEditText);
        foneEditText = findViewById(R.id.foneEditText);
        emailEditText = findViewById(R.id.emailEditText);

        configuraFirebase();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEditText.getEditableText().toString();
                String fone = foneEditText.getEditableText().toString();
                String email = emailEditText.getEditableText().toString();

                String chave = contatosReference.push().getKey();

                Contato contato = new Contato (chave, nome, fone, email);

                contatosReference.child(chave).setValue(contato);

                Toast.makeText(AdicionaContatoActivity.this,
                        getString(R.string.contato_adicionado), Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }

    private void configuraFirebase (){
        firebaseDatabase = FirebaseDatabase.getInstance();
        contatosReference = firebaseDatabase.getReference("contatos");
    }

}
