package com.example.mesegundaunidade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mFuncionario;
    Button mExterno;
    private EditText mNome;
    private EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_etapa1);

        mFuncionario = findViewById(R.id.funcionario_proximo);
        mExterno = findViewById(R.id.externo_proximo);
        mNome = findViewById(R.id.nome_cadastro);
        mEmail = findViewById(R.id.email_cadastro);

        mFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNome.getText();
                mEmail.getText();
                Intent f = new Intent(MainActivity.this, FuncionarioTela.class);
                f.putExtra("nome", mNome.toString());
                f.putExtra("email", mEmail.toString());
                startActivity(f);
            }
        });

        mExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNome.getText();
                mEmail.getText();
                Intent e = new Intent(MainActivity.this, ParticipanteTela.class);
                startActivity(e);
            }
        });

    }

}



