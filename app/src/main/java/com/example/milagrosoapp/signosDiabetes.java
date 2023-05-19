package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.milagrosoapp.DatabaseHelper.COL1;
import static com.example.milagrosoapp.DatabaseHelper.COL10;
import static com.example.milagrosoapp.DatabaseHelper.COL16;
import static com.example.milagrosoapp.DatabaseHelper.TABLE_NAME;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetIterator;
import android.os.Bundle;

public class signosDiabetes extends AppCompatActivity {

    private DatabaseHelper myDbs;

    private static final int PERMISSION_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signos_diabetes);
        myDbs = new DatabaseHelper(signosDiabetes.this);
        SQLiteDatabase db = myDbs.getReadableDatabase();
        Intent intent = getIntent();
        int valorRecibido = intent.getIntExtra("idUser", 0);
        TextInputLayout glucosaLayout = findViewById(R.id.glucosa);
        EditText editGlucosa = glucosaLayout.getEditText();

        TextInputLayout medicamentosLayout = findViewById(R.id.medicamentos);
        EditText editMedicamentos = medicamentosLayout.getEditText();

        Button signosButton = (Button) findViewById(R.id.button_registrar_diabetes);

        signosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM Registros_RapiCoop", null);;
                String glucosa = editGlucosa.getText().toString();
                String medicamentos = editMedicamentos.getText().toString();
                ContentValues values = new ContentValues();
                values.put(COL10, glucosa );
                values.put(COL16, medicamentos);
                String f= valorRecibido+"";
                String selection = COL1 + " = ?";
                String[] selectionArgs = { f };

                db.update(
                        TABLE_NAME,
                        values,
                        selection,
                        selectionArgs
                );






            }
        });

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
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void buttonVerMapa(View view) {
        Intent intent = new Intent(this, Ubicacion.class);
        startActivity(intent);
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