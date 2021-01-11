package com.ldm.everydayapainting.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.dao.CuadroDAO;
import com.ldm.everydayapainting.database.entity.Cuadro;

@Database(entities = {Cuadro.class}, version = 1)
public abstract class MyRoom extends RoomDatabase {

    private static MyRoom INSTANCE;
    public abstract CuadroDAO cuadroDAO();

    public static MyRoom getMyRoom(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoom.class, Constants.NAME_DATABASE).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
