package br.ufpi.es.checar.Visao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpi.es.checar.Persistencia.ControleBanco;
import br.ufpi.es.checar.R;

public class CadastroPlaca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_placa);

        Button botao = (Button) findViewById(R.id.buttonCadastroVeiculo);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControleBanco bd = new ControleBanco(getBaseContext());
                EditText placa = (EditText) findViewById(R.id.editPlaca);
                EditText fabricante = (EditText) findViewById(R.id.editFabricante);
                EditText modelo = (EditText) findViewById(R.id.editModelo);
                EditText versao = (EditText) findViewById(R.id.editVersao);
                EditText ano = (EditText) findViewById(R.id.editAno);
                EditText cor = (EditText) findViewById(R.id.editCor);
                EditText motor = (EditText) findViewById(R.id.editMotor);

                String Placa = placa.getText().toString();
                String Fabricante = fabricante.getText().toString();
                String Modelo = modelo.getText().toString();
                String Versao = versao.getText().toString();
                String Ano = ano.getText().toString();
                String Cor = cor.getText().toString();
                String Motor = motor.getText().toString();

                String result;

                result = bd.InserirPlaca(Placa, Fabricante, Modelo, Versao, Ano, Cor, Motor);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

                //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
