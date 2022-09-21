package com.example.bakery_app.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bakery_app.entity.Coffee;

@Database(entities = {Coffee.class}, version = 1,exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    public abstract CoffeeDAO createCoffeeDAO();

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"driver_database").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}