package br.com.facotudobrasil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by alison on 28/08/17.
 */

public class ConfirmacaoEmailECelularActivity extends AppCompatActivity {

    private Button btnAvancarConfirmacao;
    private RelativeLayout relativeImgFecharItemAlert;
    private Button btnOkAlertItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_email_celular);
        iniciadorComponente();
    }

    private void iniciadorComponente(){
        btnAvancarConfirmacao = (Button) findViewById(R.id.btnAvancarConfirmacao);
    }

    public void avancar(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ConfirmacaoEmailECelularActivity.this);
        LayoutInflater inflater = ConfirmacaoEmailECelularActivity.this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.item_alert_dialog_bem_vindo, null);
        dialogBuilder.setView(dialogView);
        iniciadorComponenteAlertDialog(dialogView);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();

        relativeImgFecharItemAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itHome = new Intent(ConfirmacaoEmailECelularActivity.this, PedidosActivity.class);
                startActivity(itHome);
                finish();
            }
        });

        btnOkAlertItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itHome = new Intent(ConfirmacaoEmailECelularActivity.this, PedidosActivity.class);
                startActivity(itHome);
                finish();
            }
        });
    }

    private void iniciadorComponenteAlertDialog(View view){
        relativeImgFecharItemAlert = (RelativeLayout) view.findViewById(R.id.relativeImgFecharItemAlert);
        btnOkAlertItem = (Button) view.findViewById(R.id.btnOkAlertItem);
    }
}
