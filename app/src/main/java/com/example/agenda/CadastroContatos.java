package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.model.Contatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CadastroContatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);

        Button buttonSalvar = findViewById(R.id.activity_cadastro_button_salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contatos contatos = new Contatos();
                EditText nome = findViewById(R.id.activity_cadastro_nome);
                contatos.setNome(nome.getText().toString());
                nome.setText("");

                EditText telefone = findViewById(R.id.activity_cadastro_telefone);
                contatos.setTelefone(telefone.getText().toString());
                telefone.setText("");

                EditText endereco = findViewById(R.id.activity_cadastro_endereco);
                contatos.setEndereco(endereco.getText().toString());
                endereco.setText("");

                EditText dataNascimento = findViewById(R.id.activity_cadastro_data_nascimento);
                try {
                    contatos.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dataNascimento.setText("");

                Toast.makeText(CadastroContatos.this, "Contato adicionado", Toast.LENGTH_LONG).show();
            }
        });

        Button buttonVoltar = findViewById(R.id.activity_cadastro_voltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(voltar);
            }
        });

    }
}