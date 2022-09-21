package com.example.bakery_app.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bakery_app.R;
import com.example.bakery_app.dao.AppDatabase;
import com.example.bakery_app.entity.Coffee;

public class RegisterActivity extends AppCompatActivity {

    EditText nome;
    EditText preco;
    EditText descricao;
    Spinner categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button cadastrar= findViewById(R.id.registerButton);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {
                nome = findViewById(R.id.editTextNome);
                preco = findViewById(R.id.editTextPreco);
                descricao = findViewById((R.id.editTextDescricao));
                categoria = findViewById(R.id.spinCategoria);
                Coffee coffee = new Coffee();
                coffee.setNome(nome.getText().toString());
                coffee.setPreco(Double.parseDouble(preco.getText().toString()));
                coffee.setDescricao(descricao.getText().toString());
                coffee.setCategoria(categoria.getSelectedItem().toString());
                AppDatabase.getInstance(getApplicationContext()).createCoffeeDAO().insert(coffee);
                Toast.makeText(getApplicationContext(), "Novo café cadastrado no Cardapio!", Toast.LENGTH_LONG).show();
                limparCampos();
            }
        });
    }

    public void cancelarCadastro(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    private void limparCampos() {
        nome = findViewById(R.id.editTextNome);
        preco = findViewById(R.id.editTextPreco);
        descricao = findViewById((R.id.editTextDescricao));
        nome.setText("");
        preco.setText("");
        descricao.setText("");
    }

}


