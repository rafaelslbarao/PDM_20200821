package br.com.rafael.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


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

                if(textView.getVisibility() == View.VISIBLE && textView.isShown())
                    textView.setText("Cliques " + contador);

                Log.d("BARAO", "Cliques " + contador);
            }
        });
    }
}