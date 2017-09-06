package br.com.facotudobrasil;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by alison on 28/08/17.
 */

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edtNomeUsuarioCadastro;
    private EditText edtSobrenomeUsuarioCadastro;
    private EditText edtTelefoneUsuarioCadastro;
    private EditText edtEmailUsuarioCadastro;
    private RadioGroup rdSegmentoCadastro;
    private RadioButton rdImoveisCadastro;
    private RadioButton rdVeiculosCadastro;
    private Button btnCadastrarUsuarioCadastro;
    private int erro;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        iniciadorComponente();
    }

    private void iniciadorComponente(){
        edtNomeUsuarioCadastro = (EditText) findViewById(R.id.edtNomeUsuarioCadastro);
        edtSobrenomeUsuarioCadastro = (EditText) findViewById(R.id.edtSobrenomeUsuarioCadastro);
        edtTelefoneUsuarioCadastro = (EditText) findViewById(R.id.edtTelefoneUsuarioCadastro);
        edtEmailUsuarioCadastro = (EditText) findViewById(R.id.edtEmailUsuarioCadastro);
        rdSegmentoCadastro = (RadioGroup) findViewById(R.id.rdSegmentoCadastro);
        rdImoveisCadastro = (RadioButton) findViewById(R.id.rdImoveisCadastro);
        rdVeiculosCadastro = (RadioButton) findViewById(R.id.rdVeiculosCadastro);
        btnCadastrarUsuarioCadastro = (Button) findViewById(R.id.btnCadastrarUsuarioCadastro);
    }

    public void cadastrarUsuario(View view) {
        erro = 0;
        if (edtNomeUsuarioCadastro.getText().toString().trim().equals("")){
            edtNomeUsuarioCadastro.setError(getString(R.string.preenchaCampo));
            edtNomeUsuarioCadastro.requestFocus();
            erro = 1;
        } else if (edtSobrenomeUsuarioCadastro.getText().toString().trim().equals("")){
            edtSobrenomeUsuarioCadastro.setError(getString(R.string.preenchaCampo));
            edtSobrenomeUsuarioCadastro.requestFocus();
            erro = 1;
        } else if (edtTelefoneUsuarioCadastro.getText().toString().trim().equals("")){
            edtTelefoneUsuarioCadastro.setError(getString(R.string.preenchaCampo));
            edtTelefoneUsuarioCadastro.requestFocus();
            erro = 1;
        } else if (edtEmailUsuarioCadastro.getText().toString().trim().equals("")){
            edtEmailUsuarioCadastro.setError(getString(R.string.preenchaCampo));
            edtEmailUsuarioCadastro.requestFocus();
            erro = 1;
        }

        if (erro == 0) {
            Intent itConfirmacao = new Intent(CadastroClienteActivity.this, ConfirmacaoEmailECelularActivity.class);
            startActivity(itConfirmacao);
        }
    }
}
