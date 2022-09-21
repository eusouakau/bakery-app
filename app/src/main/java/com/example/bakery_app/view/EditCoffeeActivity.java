package com.example.bakery_app.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bakery_app.R;
import com.example.bakery_app.dao.AppDatabase;
import com.example.bakery_app.dao.CoffeeDAO;
import com.example.bakery_app.entity.Coffee;
//TODO para aparecer a categoria correta do cafe quando abre para a edição
public class EditCoffeeActivity extends AppCompatActivity {

    EditText editTextNome ;
    EditText editTextDesc;
    EditText editTextPreco;
    Spinner spinCategoria;
    AppCompatButton botaoEditar ;
    Coffee coffee ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_coffee);
        editTextNome = this.findViewById(R.id.editTextNomeEdit);
        editTextDesc =  this.findViewById(R.id.editTextDescricaoEdit);
        editTextPreco =  this.findViewById(R.id.editTextPrecoEdit);
        spinCategoria =  this.findViewById(R.id.spinCategoriaEdit);
        botaoEditar =  this.findViewById(R.id.saveButton);

        botaoEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alterarCafe();
            }
        });
        Bundle extra =  this.getIntent().getExtras();
        coffee = (Coffee) getIntent().getSerializableExtra("cafe");
        editTextNome.setText(coffee.getNome());
        editTextDesc.setText(coffee.getDescricao());
        editTextPreco.setText(coffee.getPreco().toString());
        //spinCategoria.setOnClickListener(coffee.);
    }

    private void alterarCafe() {
        if (editTextNome.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Nome é obrigatório!", Toast.LENGTH_LONG).show();
            editTextNome.requestFocus();
        } else if (editTextDesc.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Descrição é obrigatório!", Toast.LENGTH_LONG).show();
            editTextDesc.requestFocus();
        } else if (editTextPreco.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "O preço é obrigatório!", Toast.LENGTH_LONG).show();
            editTextPreco.requestFocus();
        } else {
            coffee.setNome(editTextNome.getText().toString().trim());
            coffee.setDescricao(editTextDesc.getText().toString().trim());
            coffee.setPreco(Double.parseDouble(editTextPreco.getText().toString().trim()));
            coffee.setCategoria(spinCategoria.getSelectedItem().toString().trim());
            CoffeeDAO coffeeDAO = AppDatabase.getInstance(getApplicationContext()).createCoffeeDAO();
            coffeeDAO.update(coffee);
            mostraMensagem();
        }
    }

    public void mostraMensagem(){
        String msg = "Café alterado com sucesso! ";
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(msg);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), ManagerActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.show();
    }

    public void cancelarEdicao(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

}