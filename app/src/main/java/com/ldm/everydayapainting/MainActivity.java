package com.ldm.everydayapainting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ldm.everydayapainting.constants.Constants;
import com.ldm.everydayapainting.database.db.MyRoom;
import com.ldm.everydayapainting.database.entity.Cuadro;

public class MainActivity extends AppCompatActivity {

    private EditText edAutor, edYear, edEstilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar las views
        edAutor = findViewById(R.id.editTextAutor);
        edYear = findViewById(R.id.editTextYear);
        edEstilo = findViewById(R.id.editTextEstilo);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Limpiar los Edit Text después de una búsqueda
        // Se limpian al volver hacia atrás desde la pantalla en la que se mostrarían los cuadros buscados
        edAutor.setText("");
        edYear.setText("");
        edEstilo.setText("");
    }

    public void onClickTodos(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "all");
        startActivity(intent);
    }

    public void onClickRandom(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "random");
        startActivity(intent);
    }

    public void onClickAutor(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "author");
        intent.putExtra("data", edAutor.getText().toString());

        startActivity(intent);
    }

    public void onClickYear(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "year");
        intent.putExtra("data", edYear.getText().toString());

        startActivity(intent);
    }

    public void onClickEstilo(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "style");
        intent.putExtra("data", edEstilo.getText().toString());

        startActivity(intent);
    }

}