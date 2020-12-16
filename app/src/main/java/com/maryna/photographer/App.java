package com.maryna.photographer;

import android.app.Application;

import androidx.room.Room;

import com.maryna.photographer.db.PhotoDatabase;

public class App extends Application {

    private static App instance;

    private PhotoDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, PhotoDatabase.class, "PhotoDatabase")
                .fallbackToDestructiveMigration()
                .build(); // создаем объект бд
    }

    public static App getInstance() {
        return instance;
    }

    public PhotoDatabase getDatabase() {
        return database;
    }
}
