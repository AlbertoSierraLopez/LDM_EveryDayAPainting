package com.ldm.everydayapainting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.db.MyRoom;
import com.ldm.everydayapainting.database.entity.Cuadro;

public class MainActivity extends AppCompatActivity implements CuadroFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.deleteDatabase(Constants.NAME_DATABASE);

        Cuadro c1 = new Cuadro();
        c1.setName("El Jardín de las Delicias");
        c1.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/El_jard%C3%ADn_de_las_Delicias%2C_de_El_Bosco.jpg/1280px-El_jard%C3%ADn_de_las_Delicias%2C_de_El_Bosco.jpg");
        c1.setYear(1500);
        c1.setAuthor("El Bosco");
        c1.setTechnique("Pintura al óleo sobre tabla");
        c1.setStyle("Primitivo Flamenco");
        c1.setLocation("Museo del Prado");
        MyRoom.getMyRoom(getApplicationContext()).cuadroDAO().insertCuadro(c1);

        Cuadro c2 = new Cuadro();
        c2.setName("La Rendición de Breda");
        c2.setUrl("https://upload.wikimedia.org/wikipedia/commons/4/4e/Vel%C3%A1zquez_-_de_Breda_o_Las_Lanzas_%28Museo_del_Prado%2C_1634-35%29.jpg");
        c2.setYear(1634);
        c2.setAuthor("Diego Velázquez");
        c2.setTechnique("Óleo sobre lienzo");
        c2.setStyle("Barroco");
        c2.setLocation("Museo del Prado");
        MyRoom.getMyRoom(getApplicationContext()).cuadroDAO().insertCuadro(c2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onListFragmentInteraction(Cuadro item){

    }
}