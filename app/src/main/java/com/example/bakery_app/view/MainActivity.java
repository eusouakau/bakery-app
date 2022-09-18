package com.example.bakery_app.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bakery_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void entrarMenu(View view){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }
    //TODO colocar mapa no "como chegar até nós"
    /*public void cadastrarCafe(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }*/
}