package com.example.bakery_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bakery_app.R;

public class OptionsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ListView listaOpcoes = this.findViewById(R.id.lista);
        String[] itens = {"Cadastro", "Cardapio", "Venha até nós", "Sobre nós", "Gerenciamento", "Fale Conosco"};
        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
        listaOpcoes.setAdapter(arrayItens);
        listaOpcoes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View v, int position, long id){
        Intent intencao;
        switch(position) {
            case 0:
                intencao = new Intent(this, RegisterActivity.class);
                startActivity(intencao);
                break;
            case 1:
                intencao = new Intent(this, MenuActivity.class);
                startActivity(intencao);
                break;
            case 2:
                abrirLocalizacao(view);
                break;
            case 3:
                intencao = new Intent(this, InformationsActivity.class);
                startActivity(intencao);
                break;
            case 4:
                intencao = new Intent(this, ManagerActivity.class);
                startActivity(intencao);
                break;
            case 5:
                faleConosco(view);
                break;
            default:
                intencao = new Intent(this, MainActivity.class);
                startActivity(intencao);
        }
    }


    public void abrirLocalizacao(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-30.037719647934765(Agridoce Café)?z=15"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void faleConosco(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://starbucks.com.br/sobre/atendimento"));
        startActivity(intent);
    }
}