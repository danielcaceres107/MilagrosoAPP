package com.example.milagrosoapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Emergency extends AppCompatActivity {

    private TextView textViewUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        textViewUbicacion = findViewById(R.id.textViewUbicacion);

        double latitud = getIntent().getDoubleExtra("latitud", 0.0);
        double longitud = getIntent().getDoubleExtra("longitud", 0.0);

        String ubicacion = "Latitud: " + latitud + "\nLongitud: " + longitud;
        textViewUbicacion.setText(ubicacion);
    }
}
