package com.ldm.everydayapainting.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.dao.CuadroDAO;
import com.ldm.everydayapainting.database.entity.Cuadro;

import java.io.File;

@Database(entities = {Cuadro.class}, version = 1)
public abstract class MyRoom extends RoomDatabase {

    private static MyRoom INSTANCE;
    public abstract CuadroDAO cuadroDAO();

    public static MyRoom getMyRoom(Context context) {

        if (INSTANCE == null) {
            File file = new File("/data/data/com.ldm.everydayapainting/databases/database");

            if (!file.exists()) {   // Si la base de datos no ha sido creada, se crea y se meten cuadros

                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoom.class, Constants.NAME_DATABASE).allowMainThreadQueries().build();

                // context.deleteDatabase(Constants.NAME_DATABASE);
                Cuadro c1 = new Cuadro();
                c1.setName("El Jardín de las Delicias");
                c1.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/El_jard%C3%ADn_de_las_Delicias%2C_de_El_Bosco.jpg/1280px-El_jard%C3%ADn_de_las_Delicias%2C_de_El_Bosco.jpg");
                c1.setYear(1500);
                c1.setAuthor("El Bosco");
                c1.setTechnique("Pintura al óleo sobre tabla");
                c1.setStyle("Primitivo Flamenco");
                c1.setLocation("Museo del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c1);

                Cuadro c2 = new Cuadro();
                c2.setName("La Rendición de Breda");
                c2.setUrl("https://upload.wikimedia.org/wikipedia/commons/4/4e/Vel%C3%A1zquez_-_de_Breda_o_Las_Lanzas_%28Museo_del_Prado%2C_1634-35%29.jpg");
                c2.setYear(1634);
                c2.setAuthor("Diego Velázquez");
                c2.setTechnique("Óleo sobre lienzo");
                c2.setStyle("Barroco");
                c2.setLocation("Museo del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c2);

            } else {    // Si la base de datos ya existe, se recoge del archivo .db guardado en el almacenamiento interno
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoom.class, Constants.NAME_DATABASE).createFromFile(file).allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
