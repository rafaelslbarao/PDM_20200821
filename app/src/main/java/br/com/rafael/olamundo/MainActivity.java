package br.com.rafael.olamundo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

import br.com.rafael.dominio.Pessoa;
import br.com.rafael.dominio.PessoaFisica;
import br.com.rafael.dominio.PessoaJuridica;

public class MainActivity extends AppCompatActivity
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

                for(Pessoa pessoaFor : listaPessoa)
                {
                    Log.d("BARÃO", pessoaFor.getNome());
                }
            }
        });
    }
}