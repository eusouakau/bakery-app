package com.example.bakery_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.bakery_app.entity.Coffee;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeDAO {

    @Query("SELECT * FROM Coffee")
    public List<Coffee> getAllCoffee();

    @Query("SELECT * FROM Coffee WHERE nome = :name")
    public List<Coffee> getCoffeeByName(String name);

    @Insert(onConflict = REPLACE)
    public void insert(Coffee coffee);

    @Update
    public void update(Coffee coffee);

    @Delete
    public void delete(Coffee coffee);

}