package br.com.rafael.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrimeiraActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etCodigo;
    private EditText etEmail;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        inicializaComponentes();
        inicializaEventos();
    }

    private void inicializaComponentes()
    {
        etCodigo = findViewById(R.id.etCodigo);
        etEmail = findViewById(R.id.etEmail);
        btSalvar = findViewById(R.id.btSalvar);
    }

    private void inicializaEventos()
    {
        btSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btSalvar:
                abreSegundaTelaConfirmacao();
                break;
        }
    }

    private void abreSegundaTelaConfirmacao()
    {
        Intent intentSegundaTelaConfirmacao = new Intent(this, SegundaActivity.class);
        startActivity(intentSegundaTelaConfirmacao);
    }
}