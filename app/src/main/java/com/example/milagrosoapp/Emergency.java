package com.example.milagrosoapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Emergency extends AppCompatActivity {

    private TextView textViewUbicacion;

    private static final int PERMISSION_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        textViewUbicacion = findViewById(R.id.textViewUbicacion);

        double latitud = getIntent().getDoubleExtra("latitud", 4.7009744);
        double longitud = getIntent().getDoubleExtra("longitud", -74.1708576);

        String ubicacion_paciente = "Latitud: " + latitud + "\nLongitud: " + longitud;
        textViewUbicacion.setText(ubicacion_paciente);

        ImageButton emergencyButton = (ImageButton) findViewById(R.id.emergency_button);

        emergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callEmergencyNumber();
            }
        });

    }

    private void callEmergencyNumber() {
        // Verifica permisos para realizar llamadas
        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Si no tiene permisos, solicita al usuario que los conceda
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CALL_PHONE);
        } else {
            // Si tiene permisos, realiza la llamada
            makeEmergencyCall();
        }
    }


    private void makeEmergencyCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:*123"));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeEmergencyCall();
            } else {
                // El usuario ha denegado los permisos
                Toast.makeText(this, "No se tienen los permisos para llamar", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
