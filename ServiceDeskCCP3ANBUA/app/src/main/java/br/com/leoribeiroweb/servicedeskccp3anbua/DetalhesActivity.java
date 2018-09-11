package br.com.leoribeiroweb.servicedeskccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.leoribeiroweb.servicedeskccp3anbua.model.Chamado;

public class DetalhesActivity extends AppCompatActivity {

    private TextView nomeFilaTextView;
    private TextView descricaoChamadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        nomeFilaTextView = findViewById(R.id.nomeFilaTextView);
        descricaoChamadoTextView = findViewById(R.id.descricaoChamadoTextView);
        Intent intent = getIntent();
        Chamado oCaraQueFoiTocado = (Chamado) intent.getSerializableExtra("oCaraQueFoiTocado");
        nomeFilaTextView.setText(oCaraQueFoiTocado.getTipo().trim());
        descricaoChamadoTextView.setText(oCaraQueFoiTocado.getNome().trim());
    }
}
