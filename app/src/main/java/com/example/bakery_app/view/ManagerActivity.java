package com.example.bakery_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bakery_app.R;
import com.example.bakery_app.adapter.LinhaGerenciamentoAdapter;
import com.example.bakery_app.dao.AppDatabase;
import com.example.bakery_app.dao.CoffeeDAO;
import com.example.bakery_app.entity.Coffee;

import java.util.List;

public class ManagerActivity extends AppCompatActivity {

    private ListView managerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        managerList = this.findViewById(R.id.coffeeList);
        CoffeeDAO coffeeDAO = AppDatabase.getInstance(getApplicationContext()).createCoffeeDAO();
        getAll(coffeeDAO.getAllCoffee());
    }
    protected  void getAll(List<Coffee> cafes){
        managerList.setAdapter(new LinhaGerenciamentoAdapter(this, cafes));
    }
}