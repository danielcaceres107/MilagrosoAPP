package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.milagrosoapp.DatabaseHelper.COL1;
import static com.example.milagrosoapp.DatabaseHelper.COL11;
import static com.example.milagrosoapp.DatabaseHelper.COL16;
import static com.example.milagrosoapp.DatabaseHelper.TABLE_NAME;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetIterator;
import android.os.Bundle;

public class signosHipertension extends AppCompatActivity {
    private DatabaseHelper myDbs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signos_hipertension);
        myDbs = new DatabaseHelper(signosHipertension.this);
        SQLiteDatabase db = myDbs.getReadableDatabase();
        Intent intent = getIntent();
        int valorRecibido = intent.getIntExtra("idUser", 0);

        TextInputLayout hiperLayout = findViewById(R.id.hipertension1);
        EditText editHiper = hiperLayout.getEditText();

        TextInputLayout medicamentosLayout = findViewById(R.id.medicamentos1);
        EditText editMedicamentos = medicamentosLayout.getEditText();

        Button signosButton = (Button) findViewById(R.id.button_registrar_signos);
        signosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("SELECT * FROM Registros_RapiCoop", null);;
                String hipertension= editHiper.getText().toString();

                String medicamentos = editMedicamentos.getText().toString();
                ContentValues values = new ContentValues();
                values.put(COL11, hipertension);
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
    }
}