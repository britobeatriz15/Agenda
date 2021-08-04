package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        List<String> contatos = new ArrayList<>();
        contatos.add("Beatriz");
        contatos.add("Igor");
        contatos.add("Marcio");
        contatos.add("Ramon");
        contatos.add("Vitoria");
        ListView listaContatos = findViewById(R.id.activity_principal_contatos);
        listaContatos.setAdapter(new ArrayAdapter<String>(PrincipalActivity.this,, contatos));

        FloatingActionButton floatingActionButton = findViewById(R.id.activity_principal_fab_adicionar);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalActivity.this,CadastroContatos.class));
            }
        });

    }
}