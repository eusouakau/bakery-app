package com.example.bakery_app.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.bakery_app.R;
import com.example.bakery_app.dao.AppDatabase;
import com.example.bakery_app.dao.CoffeeDAO;
import com.example.bakery_app.entity.Coffee;
import com.example.bakery_app.view.EditCoffeeActivity;
import com.example.bakery_app.view.ManagerActivity;

import java.util.ArrayList;
import java.util.List;


public class LinhaGerenciamentoAdapter extends BaseAdapter {

    //Cria objeto LayoutInflater para ligar com a View activity_manager_row.xml
    private static LayoutInflater layoutInflater = null;
    List<Coffee> cafes =  new ArrayList<>();

    //Cria objeto do tipo que lista as tarefas
    private ManagerActivity listarCafes;

    //Construtor que recebe a ativida como parametro e a lista de tarefas que vai retornar do BD
    public LinhaGerenciamentoAdapter(ManagerActivity listarCafes, List<Coffee> cafes ) {
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

    //Método converte os valores de um item  da lista de Cafés para uma linha do ListView
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Cria um objeto para acessar o layout activity_row.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_manager_row,null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        AppCompatTextView textViewNome  =  viewLinhaLista.findViewById(R.id.textViewNome);
        AppCompatTextView textViewPreco = viewLinhaLista.findViewById(R.id.textViewPreco);
        AppCompatTextView textViewDescricao = viewLinhaLista.findViewById(R.id.textViewDescricao);
        AppCompatTextView textViewCategoria = viewLinhaLista.findViewById(R.id.textViewCategoria);
        AppCompatButton buttonExcluir = viewLinhaLista.findViewById(R.id.buttonExcluir);
        AppCompatButton buttonEditar = viewLinhaLista.findViewById(R.id.buttonEditar);

        textViewNome.setText(cafes.get(position).getNome());
        textViewPreco.setText(cafes.get(position).getPreco());
        textViewDescricao.setText(cafes.get(position).getDescricao());
        textViewCategoria.setText(cafes.get(position).getCategoria());

        //Criando evento para excluir um registro do BD
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoffeeDAO coffeeDAO = AppDatabase.getInstance(listarCafes.getApplicationContext()).createCoffeeDAO();
                List<Coffee> cafes = coffeeDAO.getAllCoffee();
                coffeeDAO.delete(cafes.get(position));
                atualizaLista(position);
            }
        });

        //Criando evento para editar um registro do BD
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listarCafes, EditCoffeeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("cafe",cafes.get(position));
                listarCafes.startActivity(intent);
            }
        });
        return viewLinhaLista;
    }

    //atualizando a lista após excluir registro
    public void atualizaLista(int position){
        String mensagem = "Café excluído com sucesso!";
        Toast.makeText(listarCafes, mensagem, Toast.LENGTH_LONG).show();
        this.cafes.remove(position);
        this.notifyDataSetChanged();
    }

}