package br.com.leoribeiroweb.helloworldccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Author: Leonardo Ribeiro
 * RA: 816119319
 */
public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Intent intent = getIntent();
        String texto = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView displayTextView = findViewById(R.id.displayTextView);
        displayTextView.setText(texto);
    }
}
