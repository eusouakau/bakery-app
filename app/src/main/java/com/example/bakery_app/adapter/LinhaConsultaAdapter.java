package com.example.bakery_app.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.bakery_app.R;
import com.example.bakery_app.entity.Coffee;
import com.example.bakery_app.view.MenuActivity;

import java.util.List;


public class LinhaConsultaAdapter extends BaseAdapter {

    //Cria objeto LayoutInflater para ligar com a View activity_row.xml
    private static LayoutInflater layoutInflater = null;
    List<Coffee> cafes;

    //Cria objeto do tipo que lista os cafés
    private MenuActivity listarCafes;

    //Construtor que recebe a ativide como parametro e a lista de cafes que vai retornar do BD
    public LinhaConsultaAdapter(MenuActivity listarCafes, List<Coffee> cafes ) {
        this.cafes = cafes;
        this.listarCafes =  listarCafes;
        this.layoutInflater = (LayoutInflater) this.listarCafes.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //Retorna a quantidade de objetos que esta na lista
    @Override
    public int getCount(){
        return cafes.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    //Método converte os valores de um item  da lista de Coffee para uma linha do ListView
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Cria um objeto para acessar o layout activity_row.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_row,null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        AppCompatTextView textViewNome  =  viewLinhaLista.findViewById(R.id.textViewNome);
        AppCompatTextView textViewPreco = viewLinhaLista.findViewById(R.id.textViewPreco);
        AppCompatTextView textViewDescricao = viewLinhaLista.findViewById(R.id.textViewDescricao);
        AppCompatTextView textViewCategoria = viewLinhaLista.findViewById(R.id.textViewCategoria);

        textViewNome.setText(cafes.get(position).getNome());
        textViewPreco.setText(cafes.get(position).getPreco());
        textViewDescricao.setText(cafes.get(position).getDescricao());
        textViewCategoria.setText(cafes.get(position).getCategoria());

        return viewLinhaLista;
    }

}