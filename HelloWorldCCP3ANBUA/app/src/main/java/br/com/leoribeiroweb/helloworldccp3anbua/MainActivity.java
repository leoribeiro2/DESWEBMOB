package br.com.leoribeiroweb.helloworldccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Author: Leonardo Ribeiro
 * RA: 816119319
 */
public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarMensagem(View view) {
        Intent intent = new Intent(this, SegundaActivity.class);
        mainEditText = findViewById(R.id.mainEditText);
        String texto = mainEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, texto);
        startActivity(intent);
    }
}
