package com.example.bakery_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bakery_app.R;
import com.example.bakery_app.adapter.LinhaConsultaAdapter;
import com.example.bakery_app.dao.AppDatabase;
import com.example.bakery_app.dao.CoffeeDAO;
import com.example.bakery_app.entity.Coffee;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menuList = this.findViewById(R.id.coffeeList);
        CoffeeDAO coffeeDAO = AppDatabase.getInstance(getApplicationContext()).createCoffeeDAO();
        getAll(coffeeDAO.getAllCoffee());
    }
    protected  void getAll(List<Coffee> cafes){
        menuList.setAdapter(new LinhaConsultaAdapter(this, cafes));
    }
}