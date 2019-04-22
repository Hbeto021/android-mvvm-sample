package com.home.hbeto021.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.home.hbeto021.data.database.dao.MovieDao;
import com.home.hbeto021.domain.model.Movie;

/**
 * This class is the app database where is defined:
 * database name
 * database tables
 * interfaces dao
 * also get an instance from database
 */

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static String DB_NAME = "movie_db";
    private static AppDataBase INSTANCE;

    public abstract MovieDao movieDao();

    public static AppDataBase getDataBase(Context contexto) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(contexto, AppDataBase.class, DB_NAME).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
