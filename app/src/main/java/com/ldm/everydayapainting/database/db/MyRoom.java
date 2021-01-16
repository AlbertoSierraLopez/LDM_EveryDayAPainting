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

                /* Entradas */
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

                Cuadro c3 = new Cuadro();
                c3.setName("El 3 de mayo en Madrid");
                c3.setUrl("https://upload.wikimedia.org/wikipedia/commons/f/fd/El_Tres_de_Mayo%2C_by_Francisco_de_Goya%2C_from_Prado_thin_black_margin.jpg");
                c3.setYear(1813);
                c3.setAuthor("Francisco de Goya");
                c3.setTechnique("Óleo sobre lienzo");
                c3.setStyle("Prerromanticismo");
                c3.setLocation("Museo del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c3);

                Cuadro c4 = new Cuadro();
                c4.setName("Descendimiento de la cruz");
                c4.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Weyden-descendimiento-prado-Ca-1435.jpg/755px-Weyden-descendimiento-prado-Ca-1435.jpg");
                c4.setYear(1436);
                c4.setAuthor("Rogier van der Weyden");
                c4.setTechnique("Óleo sobre tabla");
                c4.setStyle("Gótico");
                c4.setLocation("Museo del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c4);

                Cuadro c5 = new Cuadro();
                c5.setName("La familia de Carlos IV");
                c5.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/La_familia_de_Carlos_IV%2C_por_Francisco_de_Goya.jpg/718px-La_familia_de_Carlos_IV%2C_por_Francisco_de_Goya.jpg");
                c5.setYear(1800);
                c5.setAuthor("Francisco de Goya");
                c5.setTechnique("Óleo sobre lienzo");
                c5.setStyle("Neoclasicismo");
                c5.setLocation("Muse del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c5);

                Cuadro c6 = new Cuadro();
                c6.setName("El caballero de la mano en el pecho");
                c6.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/El_caballero_de_la_mano_en_el_pecho.jpg/473px-El_caballero_de_la_mano_en_el_pecho.jpg");
                c6.setYear(1580);
                c6.setAuthor("El Bosco");
                c6.setTechnique("Óleo sobre lienzo");
                c6.setStyle("Manierismo");
                c6.setLocation("Museo del Prado");
                INSTANCE.cuadroDAO().insertCuadro(c6);

                Cuadro c7 = new Cuadro();
                c7.setName("La masacre de los inocentes");
                c7.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Peter_Paul_Rubens_Massacre_of_the_Innocents.jpg/768px-Peter_Paul_Rubens_Massacre_of_the_Innocents.jpg");
                c7.setYear(1611);
                c7.setAuthor("Pedro Pablo Rubens");
                c7.setTechnique("Óleo sobre tabla");
                c7.setStyle("Barroco");
                c7.setLocation("Galería de Arte de Ontario");
                INSTANCE.cuadroDAO().insertCuadro(c7);

                Cuadro c8 = new Cuadro();
                c8.setName("Lección de anatomía del Dr. Nicolaes Tulp");
                c8.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Rembrandt_-_The_Anatomy_Lesson_of_Dr_Nicolaes_Tulp.jpg/796px-Rembrandt_-_The_Anatomy_Lesson_of_Dr_Nicolaes_Tulp.jpg");
                c8.setYear(1632);
                c8.setAuthor("Rembrandt");
                c8.setTechnique("Óleo sobre lienzo");
                c8.setStyle("Barroco");
                c8.setLocation("Mauritshuis");
                INSTANCE.cuadroDAO().insertCuadro(c8);

                Cuadro c9 = new Cuadro();
                c9.setName("Apolo y Marsias");
                c9.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Jos%C3%A9_de_Ribera_003.jpg/1024px-Jos%C3%A9_de_Ribera_003.jpg");
                c9.setYear(1637);
                c9.setAuthor("José de Ribera");
                c9.setTechnique("Óleo sobre tela");
                c9.setStyle("Barroco");
                c9.setLocation("Museo real de Bellas Artes de Bélgica");
                INSTANCE.cuadroDAO().insertCuadro(c9);

                Cuadro c10 = new Cuadro();
                c10.setName("El caballero, la muerte y el diablo");
                c10.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Albrecht_D%C3%BCrer_-_Knight%2C_Death_and_the_Devil.jpg/461px-Albrecht_D%C3%BCrer_-_Knight%2C_Death_and_the_Devil.jpg");
                c10.setYear(1513);
                c10.setAuthor("Alberto Durero");
                c10.setTechnique("Buril sobre plancha de metal");
                c10.setStyle("Gótico");
                c10.setLocation("Museo del Louvre");
                INSTANCE.cuadroDAO().insertCuadro(c10);

                Cuadro c11 = new Cuadro();
                c11.setName("Venus de Urbino");
                c11.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Tizian_102.jpg/800px-Tizian_102.jpg");
                c11.setYear(1538);
                c11.setAuthor("Tiziano");
                c11.setTechnique("Óleo sobre lienzo");
                c11.setStyle("Manierismo");
                c11.setLocation("Galería Uffizi");
                INSTANCE.cuadroDAO().insertCuadro(c11);

                Cuadro c12 = new Cuadro();
                c12.setName("La vocación de San Mateo");
                c12.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Caravaggio_%281571-1610%29_-_De_roeping_van_Matte%C3%BCs_%281599-1600%29_-_Rome_San_Luigi_dei_Francesi_10-01-2011_12-07-56.png/594px-Caravaggio_%281571-1610%29_-_De_roeping_van_Matte%C3%BCs_%281599-1600%29_-_Rome_San_Luigi_dei_Francesi_10-01-2011_12-07-56.png");
                c12.setYear(1601);
                c12.setAuthor("Caravaggio");
                c12.setTechnique("Óleo sobre lienzo");
                c12.setStyle("Barroco");
                c12.setLocation("Iglesia de San Luis de los Franceses");
                INSTANCE.cuadroDAO().insertCuadro(c12);

                Cuadro c13 = new Cuadro();
                c13.setName("El hijo del hombre");
                c13.setUrl("https://upload.wikimedia.org/wikipedia/en/e/e5/Magritte_TheSonOfMan.jpg");
                c13.setYear(1964);
                c13.setAuthor("René Magritte");
                c13.setTechnique("Óleo sobre lienzo");
                c13.setStyle("Surrealismo");
                c13.setLocation("Colección privada");
                INSTANCE.cuadroDAO().insertCuadro(c13);

                Cuadro c14 = new Cuadro();
                c14.setName("La habitación azul");
                c14.setUrl("https://upload.wikimedia.org/wikipedia/en/thumb/7/75/Picasso%27s_Blue_Room_1901.jpg/734px-Picasso%27s_Blue_Room_1901.jpg");
                c14.setYear(1901);
                c14.setAuthor("Pablo Picasso");
                c14.setTechnique("Óleo sobre lienzo");
                c14.setStyle("Periodo Azul");
                c14.setLocation("La colección Phillips");
                INSTANCE.cuadroDAO().insertCuadro(c14);

                Cuadro c15 = new Cuadro();
                c15.setName("La lechera");
                c15.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Johannes_Vermeer_-_Het_melkmeisje_-_Google_Art_Project.jpg/800px-Johannes_Vermeer_-_Het_melkmeisje_-_Google_Art_Project.jpg");
                c15.setYear(1658);
                c15.setAuthor("Johannes Vermeer");
                c15.setTechnique("Óleo sobre lienzo");
                c15.setStyle("Barroco");
                c15.setLocation("Rijksmuseum");
                INSTANCE.cuadroDAO().insertCuadro(c15);

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
