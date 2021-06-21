package com.example.jadwal_sholat.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataInput.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DataInputDAO dao();
    public static AppDatabase appDatabase;

    public static AppDatabase iniDB(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class,"dbDataInput").
                    allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
}
