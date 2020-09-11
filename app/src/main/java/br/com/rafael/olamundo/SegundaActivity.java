package br.com.rafael.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.rafael.dominio.Cliente;

public class SegundaActivity extends AppCompatActivity
{
    private TextView tvCodigo;
    private TextView tvEmail;
    private Button btConfirmar;
    private Button btCancelar;
    //
    private String codigo;
    private String email;
    private Cliente cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        inicializaComponentes();
        carregaParametros();
    }

    private void inicializaComponentes()
    {
        tvCodigo = findViewById(R.id.tvCodigo);
        tvEmail = findViewById(R.id.tvEmail);
        btConfirmar = findViewById(R.id.btConfirmar);
        btCancelar = findViewById(R.id.btCancelar);
        //
        btConfirmar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                confirmaTela();
            }
        });
        //
        btCancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                cancelaTela();
            }
        });
    }

    private void carregaParametros()
    {
        //Recebendo valores primitivos
        codigo = getIntent().getStringExtra(NomeParametros.CODIGO);
        email = getIntent().getStringExtra(NomeParametros.EMAIL);
        //Recebendo objetos de um classe
        cliente = (Cliente) getIntent().getSerializableExtra(NomeParametros.CLIENTE);
        //
        tvCodigo.setText(cliente.getCodigo().toString());
        tvEmail.setText(cliente.getEmail());
    }

    private void confirmaTela()
    {
        cliente.setConfirmado(true);

        Intent intentResultado = new Intent();
        intentResultado.putExtra(NomeParametros.CLIENTE, cliente);

        setResult(RESULT_OK, intentResultado);

        finish();
    }

    private void cancelaTela()
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}