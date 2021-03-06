package com.example.taskapp;

import android.app.Application;

import androidx.room.Room;

import com.example.taskapp.room.AppDatabase;

public class App extends Application {

    private static AppDatabase database;
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database").allowMainThreadQueries().build();
    }

    public static AppDatabase getDatabase() {
        return database;
    }

    public static App getInstance() {
        return instance;
    }
}
