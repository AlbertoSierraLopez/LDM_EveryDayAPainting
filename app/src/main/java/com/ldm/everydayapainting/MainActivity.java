package com.ldm.everydayapainting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.ldm.everydayapainting.database.db.MyRoom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAutor, editTextSiglo;
    private Spinner spinnerEstilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar las views
        editTextAutor = findViewById(R.id.editTextAutor);
        editTextSiglo = findViewById(R.id.editTextSiglo);

        // Poner en el spinner todos los estilos guardados
        spinnerEstilo = (Spinner)findViewById(R.id.spinnerEstilo);

        // Lista de estilos
        ArrayList<String> spinnerList = new ArrayList<>();
        spinnerList.add("Selecciona un estilo");
        spinnerList.addAll(MyRoom.getMyRoom(this).cuadroDAO().findAllStyle());

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstilo.setAdapter(spinnerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Limpiar los Edit Text después de una búsqueda
        // Se limpian al volver hacia atrás desde la pantalla en la que se mostrarían los cuadros buscados
        editTextAutor.setText("");
        editTextSiglo.setText("");
        // También se limpia el spinner colocando la selección sobre la opción 0, que es el hint
        spinnerEstilo.setSelection(0);
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
        intent.putExtra("data", editTextAutor.getText().toString());

        startActivity(intent);
    }

    public void onClickSiglo(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "century");
        intent.putExtra("data", editTextSiglo.getText().toString());

        startActivity(intent);
    }

    public void onClickEstilo(View v) {
        Intent intent = new Intent(this, CuadroActivity.class);
        intent.putExtra("query", "style");
        intent.putExtra("data", spinnerEstilo.getSelectedItem().toString());

        startActivity(intent);
    }

}