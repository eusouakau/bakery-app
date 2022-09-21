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

    private static LayoutInflater layoutInflater = null;
    List<Coffee> cafes;

    private MenuActivity listarCafes;

    public LinhaConsultaAdapter(MenuActivity listarCafes, List<Coffee> cafes ) {
        this.cafes = cafes;
        this.listarCafes =  listarCafes;
        this.layoutInflater = (LayoutInflater) this.listarCafes.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_row,null);

        AppCompatTextView textViewNome  =  viewLinhaLista.findViewById(R.id.textViewNome);
        AppCompatTextView textViewPreco = viewLinhaLista.findViewById(R.id.textViewPreco);
        AppCompatTextView textViewDescricao = viewLinhaLista.findViewById(R.id.textViewDescricao);
        AppCompatTextView textViewCategoria = viewLinhaLista.findViewById(R.id.textViewCategoria);

        textViewNome.setText(cafes.get(position).getNome());
        textViewPreco.setText(String.valueOf(cafes.get(position).getPreco()));
        textViewDescricao.setText(cafes.get(position).getDescricao());
        textViewCategoria.setText(cafes.get(position).getCategoria());

        return viewLinhaLista;
    }

}