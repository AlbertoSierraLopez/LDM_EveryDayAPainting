package com.ldm.everydayapainting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ldm.everydayapainting.CuadroFragment;
import com.ldm.everydayapainting.R;
import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.db.MyRoom;
import com.ldm.everydayapainting.database.entity.Cuadro;

public class CuadroActivity extends AppCompatActivity implements CuadroFragment.OnListFragmentInteractionListener {

    private String query, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        query = getIntent().getStringExtra("query");
        data = getIntent().getStringExtra("data");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadro);

    }

    public String getQuery() {
        return query;
    }

    public String getData() {
        return data;
    }

    public void onListFragmentInteraction(Cuadro item){

    }
}