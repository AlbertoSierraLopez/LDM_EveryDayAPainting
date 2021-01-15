package com.ldm.everydayapainting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.ldm.everydayapainting.database.db.MyRoom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAutor, editTextSiglo;
    private Spinner spinnerEstilo;
    private ImageButton btnVolumen;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Configurar las views
        editTextAutor = findViewById(R.id.editTextAutor);
        editTextSiglo = findViewById(R.id.editTextSiglo);
        spinnerEstilo = (Spinner) findViewById(R.id.spinnerEstilo);
        btnVolumen = findViewById(R.id.btnVolumen);

        // Poner la música
        mp = MediaPlayer.create(this, R.raw.museum_entrance);
        mp.setLooping(true);
        mp.start();

        // Poner en el spinner todos los estilos guardados
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

    public void onClickAyuda(View v) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void onClickVolumen(View v) {
        if (mp.isPlaying()) {
            mp.pause();
            btnVolumen.setImageResource(R.drawable.ic_baseline_volume_off_24);
        } else {
            mp.start();
            btnVolumen.setImageResource(R.drawable.ic_baseline_volume_up_24);
        }
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