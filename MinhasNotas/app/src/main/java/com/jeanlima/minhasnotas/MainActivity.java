package com.jeanlima.minhasnotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText etNota;
    FloatingActionButton fabGravar;

    AnotacaoPreferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNota = findViewById(R.id.etNota);
        fabGravar = findViewById(R.id.fabGravarNota);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        fabGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nota = etNota.getText().toString();

                if(nota.equals("")){
                    Snackbar.make(v,"Preencher nota antes de salvar",Snackbar.LENGTH_LONG).show();
                } else {
                   preferencias.salvarAnotacao(nota);
                    Snackbar.make(v,"Nota salva com sucesso!",Snackbar.LENGTH_LONG).show();
                }
            }
        });

        String anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")){
            etNota.setText(anotacao);
        }
    }
}