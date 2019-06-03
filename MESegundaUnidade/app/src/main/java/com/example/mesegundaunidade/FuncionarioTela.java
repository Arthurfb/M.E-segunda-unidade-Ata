package com.example.mesegundaunidade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FuncionarioTela extends AppCompatActivity {

    private String sexoTexto;
    private int qtdEmissores = 0;

    private ArrayList nomesFuncionarios = new ArrayList<ArrayList>();
    private ArrayList emailsFuncionarios = new ArrayList<ArrayList>();
    private ArrayList matriculaFuncionarios = new ArrayList<ArrayList>();
    private ArrayList nascimentoFuncionarios = new ArrayList<ArrayList>();
    private ArrayList sexoFuncionarios = new ArrayList<ArrayList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario_tela);

        Button mCadastrar = findViewById(R.id.mais_funcionario);
        Button mAta = findViewById(R.id.ir_ata);

        final EditText mNome = findViewById(R.id.nome_funcionario);
        final EditText mEmail = findViewById(R.id.email_funcionario);
        final EditText mMatricula = findViewById(R.id.matricula_funcionario);
        final EditText mNascimento = findViewById(R.id.nascimento_funcionario);
        final RadioGroup mEmissor = findViewById(R.id.emissor_group);
        final TextView mEmissorTexto = findViewById(R.id.texto_emissor);
        final TextView mNomeTexto = findViewById(R.id.texto_nome_func);
        final TextView mEmailTexto = findViewById(R.id.texto_email_func);

        mNome.setVisibility(View.GONE);
        mNomeTexto.setVisibility(View.GONE);
        mEmail.setVisibility(View.GONE);
        mEmailTexto.setVisibility(View.GONE);

        mCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recebe a string nome da activity anterior
                String nome = getIntent().getStringExtra("nome");
                nomesFuncionarios.add(nome);
                //Recebe a string email da activity anterior
                String email = getIntent().getStringExtra("email");
                emailsFuncionarios.add(email);

                //Recebe o nome e adiciona na matriz nomesFuncionarios
                nome = mNome.getText().toString();
                nomesFuncionarios.add(nome);
                //Recebe o email e adiciona na matriz emailsFuncionarios
                email = mEmail.getText().toString();
                emailsFuncionarios.add(email);
                //Recebe a matrícula e adiciona na matriz matriculasFuncionarios
                String matricula = mMatricula.getText().toString();
                int matriculaInt = new Integer(matricula).intValue();
                matriculaFuncionarios.add(matriculaInt);
                //Recebe a data de nascimento e adiciona na matriz nascimentoFuncionarios
                String nascimento = mNascimento.getText().toString();
                Date nascimentoDate = null;
                try {
                    nascimentoDate = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                nascimentoFuncionarios.add(nascimentoDate);
                //Some com a escolha de emissor
                if (qtdEmissores == 1) {
                    mEmissor.setVisibility(View.GONE);
                    mEmissorTexto.setVisibility(View.GONE);
                } else {
                    mEmissor.setVisibility(View.VISIBLE);
                    mEmissorTexto.setVisibility(View.VISIBLE);
                }
                //Caso cadastre outro funcionario, vai aparecer na tela pedindo o nome e o email
                mNome.setVisibility(View.VISIBLE);
                mNomeTexto.setVisibility(View.VISIBLE);
                mEmail.setVisibility(View.VISIBLE);
                mEmailTexto.setVisibility(View.VISIBLE);
                //Apaga o que esta escrito nas EditText view
                mNome.setText(null);
                mEmail.setText(null);
                mMatricula.setText(null);
                mNascimento.setText(null);
                Toast.makeText(FuncionarioTela.this, "Cadastre o proximo funcionário", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*
     *   Recebe o sexo e adiciona na matriz sexoFuncionarios
     */
    public void sexoDefinicao(View view) {
        boolean sexo = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sexo_m:
                if (sexo)
                    sexoTexto = "Masculino";
                break;
            case R.id.sexo_f:
                if (sexo)
                    sexoTexto = "Feminino";
                break;
        }
        sexoFuncionarios.add(sexoTexto);
    }

    /*
     *   Para saber se funcionario é o emissor
     */
    public void emissorTeste(View view) {
        boolean emissor = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.emissor_sim:
                if (emissor)
                    qtdEmissores += 1;
                break;
            case R.id.emissor_nao:
                if (emissor)
                    qtdEmissores += 0;
                break;
        }
    }
}

