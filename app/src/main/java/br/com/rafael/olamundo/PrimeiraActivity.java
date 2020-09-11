package br.com.rafael.olamundo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafael.dominio.Cliente;

public class PrimeiraActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etCodigo;
    private EditText etEmail;
    private Button btSalvar;
    //
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
        inicializaComponentes();
        inicializaEventos();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentResultado)
    {
        super.onActivityResult(requestCode, resultCode, intentResultado);
        switch (requestCode)
        {
            case NomeParametros.REQUEST_CODE_SEGUNDA_TELA:
                if(resultCode == RESULT_OK)
                {
                    Cliente clienteResultado = (Cliente) intentResultado.getSerializableExtra(NomeParametros.CLIENTE);
                    this.cliente = clienteResultado;
                    exibeToastPadrao("Cliente cadastrado e o valor da confirmação é " + cliente.getConfirmado());
                    finish();
                }
                else if(resultCode == RESULT_CANCELED)
                {
                    exibeToastPadrao("O usuário cancelou!");
                }
                break;
            case NomeParametros.REQUEST_CODE_TERCEIRA_TELA:
                break;
        }
    }

    private void exibeToastPadrao(String mensagemToast)
    {
        Toast toast = Toast.makeText(this, mensagemToast, Toast.LENGTH_LONG);
        toast.show();
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
        //Passagem de valores primitivos
        intentSegundaTelaConfirmacao.putExtra(NomeParametros.CODIGO, etCodigo.getText().toString());
        intentSegundaTelaConfirmacao.putExtra(NomeParametros.EMAIL, etEmail.getText().toString());
        //Passagem de objeto de uma classe
        cliente = new Cliente();
        cliente.setCodigo(Long.valueOf(etCodigo.getText().toString()));
        cliente.setEmail(etEmail.getText().toString());
        cliente.setConfirmado(false);
        intentSegundaTelaConfirmacao.putExtra(NomeParametros.CLIENTE, cliente);
        //
        //Chama uma nova tela sem esperar resultado
        //startActivity(intentSegundaTelaConfirmacao);
        //Chama uma nova tela ESPERANDO resultao
        startActivityForResult(intentSegundaTelaConfirmacao, NomeParametros.REQUEST_CODE_SEGUNDA_TELA);
    }
}