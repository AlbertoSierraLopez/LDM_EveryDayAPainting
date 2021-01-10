package com.ldm.everydayapainting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.entity.Cuadro;

public class MainActivity extends AppCompatActivity implements CuadroFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.deleteDatabase(Constants.NAME_DATABASE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onListFragmentInteraction(Cuadro item){

    }
}