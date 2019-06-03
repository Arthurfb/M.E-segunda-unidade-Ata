package com.example.mesegundaunidade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ParticipanteTela extends AppCompatActivity {

    private ArrayList nomesParticipantes = new ArrayList<ArrayList>();
    private ArrayList emailsParticipantes = new ArrayList<ArrayList>();
    private ArrayList empresaParticipantes = new ArrayList<ArrayList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante_tela);
        Button maisParticipante = findViewById(R.id.mais_participante);

        final TextView mNomeTexto = findViewById(R.id.texto_nome_part);
        final TextView mEmailTexto = findViewById(R.id.texto_email_part);
        final EditText mNome = findViewById(R.id.nome_participante);
        final EditText mEmail = findViewById(R.id.email_participante);
        final EditText mEmpresa = findViewById(R.id.empresa_participante);

        mNomeTexto.setVisibility(View.GONE);
        mNome.setVisibility(View.GONE);
        mEmail.setVisibility(View.GONE);
        mEmailTexto.setVisibility(View.GONE);

        maisParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNomeTexto.setVisibility(View.VISIBLE);
                mNome.setVisibility(View.VISIBLE);
                mEmail.setVisibility(View.VISIBLE);
                mEmailTexto.setVisibility(View.VISIBLE);

                //Recebe a string nome da activity anterior
                String nome = getIntent().getStringExtra("nome");
                nomesParticipantes.add(nome);
                //Recebe a string email da activity anterior
                String email = getIntent().getStringExtra("email");
                emailsParticipantes.add(email);

                //Recebe o nome adiciona na matriz nomesParticipantes
                mNome.getText().toString();
                nomesParticipantes.add(mNome);
                //Recebe o email e adiciona na matriz emailsParticipantes
                mEmail.getText().toString();
                emailsParticipantes.add(mEmail);
                //Recebe e adiciona a empresa na matriz empresasParticipantes
                mEmpresa.getText().toString();
                empresaParticipantes.add(mEmpresa);

                Toast.makeText(ParticipanteTela.this, "Cadastre o próximo participante", Toast.LENGTH_LONG).show();
            }
        });
    }
}
