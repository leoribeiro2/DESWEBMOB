package com.example.leonardo.transicaodetelasccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Author: Leonardo Ribeiro
 * RA: 816119319
 */
public class SegundaActivity extends AppCompatActivity {

    private TextView textoTextView;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclodevida", "SegundaActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclodevida", "SegundaActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclodevida", "SegundaActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclodevida", "SegundaActivity:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclodevida", "SegundaActivity:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclodevida", "SegundaActivity:onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textoTextView  = (TextView) findViewById(R.id.textoTextView);
        Intent intentDeOrigem = getIntent();
        String msg = intentDeOrigem.getStringExtra("texto");
        textoTextView.setText(msg);
    }
}
