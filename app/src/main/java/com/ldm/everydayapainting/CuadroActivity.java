package com.ldm.everydayapainting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ldm.everydayapainting.CuadroFragment;
import com.ldm.everydayapainting.R;
import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.db.MyRoom;
import com.ldm.everydayapainting.database.entity.Cuadro;

public class CuadroActivity extends AppCompatActivity implements CuadroFragment.OnListFragmentInteractionListener {

    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        query = getIntent().getStringExtra("query");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadro);

    }

    public String getQuery() {
        return query;
    }

    public void onListFragmentInteraction(Cuadro item){

    }
}