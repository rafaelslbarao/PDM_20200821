package br.com.rafael.olamundo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.com.rafael.dominio.Pessoa;
import br.com.rafael.dominio.PessoaFisica;
import br.com.rafael.dominio.PessoaJuridica;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView textView;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                contador++;

                if (textView.getVisibility() == View.VISIBLE && textView.isShown())
                    textView.setText("Cliques " + contador);

                Log.d("BARAO", "Cliques " + contador);

                PessoaFisica pessoa1 = new PessoaFisica(1, "Rafael", "111.111.111-11");
                PessoaJuridica pessoa2 = new PessoaJuridica(2, "Barão", "01.0001.0001/0001-1");
                //


                Pessoa pessoa = pessoa1;
                pessoa.setNome("MarcUs");

                PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;

                //
                Log.d("BARÃO", pessoa1.getNome());
                Log.d("BARÃO", pessoa.getNome());
                //
                ArrayList<Pessoa> listaPessoa = new ArrayList<>();
                listaPessoa.add(pessoa1);
                listaPessoa.add(pessoa2);
                listaPessoa.remove(0);
                listaPessoa.remove(pessoa2);

                for (Pessoa pessoaFor : listaPessoa)
                {
                    Log.d("BARÃO", pessoaFor.getNome());
                }
            }
        });
        //
        Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(this);
        //
        Button btToast = findViewById(R.id.btToast);
        btToast.setOnClickListener(this);
        //
        Button btNovaTela = findViewById(R.id.btNovaTela);
        btNovaTela.setOnClickListener(this);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btDialog:
                abreaDialog();
                break;
            case R.id.btToast:
                exibeToastPadrao("Testando o botão!");
                break;
            case R.id.btNovaTela:
                abreNovaTelaSemEsperarResposta();
                break;
        }
    }

    private void abreNovaTelaSemEsperarResposta()
    {
        Intent novaTela = new Intent(this, PrimeiraActivity.class);
        startActivity(novaTela);
    }

    private void abreaDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Título do Meu Dialog");
        builder.setMessage("Ola, tudo bem com você?");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_baseline_perm_device_information_24);
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                exibeToastCustomizado("Então ta bom!");
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                exibeToastCustomizado("Problema é seu!");
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    private void exibeToastPadrao(String mensagemToast)
    {
        Toast toast = Toast.makeText(this, mensagemToast, Toast.LENGTH_LONG);
        toast.show();
    }

    private void exibeToastCustomizado(String mensagemToast)
    {
        //Responsável por interpretar um XML de layout e criar os objetos representados
        LayoutInflater construtorLayout = getLayoutInflater();
        View viewToast = construtorLayout.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root_layout));
        TextView textView = viewToast.findViewById(R.id.tvToast);
        textView.setText(mensagemToast);
        //
        Toast toast = new Toast(this);
        toast.setView(viewToast);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}