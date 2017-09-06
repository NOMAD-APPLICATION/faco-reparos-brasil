package br.com.facotudobrasil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaginaInicialActivity extends AppCompatActivity {

    private Button btnSejaParceiroPaginaInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);
        iniciadorComponente();
    }

    private void iniciadorComponente(){
        btnSejaParceiroPaginaInicial = (Button) findViewById(R.id.btnSejaParceiroPaginaInicial);
    }

    public void sejaParceiro(View view){
        Intent itCadastro = new Intent(PaginaInicialActivity.this, CadastroClienteActivity.class);
        startActivity(itCadastro);
    }
}
