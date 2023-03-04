package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarSignos extends AppCompatActivity {
    EditText glucosa, hipertension, incardiaca;
    Button registrarSignos;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_signos);
        glucosa = (EditText) findViewById(R.id.glucosa2);
        hipertension = (EditText) findViewById(R.id.hipertension2);
        incardiaca = (EditText) findViewById(R.id.incardiaca2);
        registrarSignos = (Button) findViewById(R.id.button_registrar_signos);
        //dao = new daoUsuario(this);

    }

    public void button_registrar_signos(View view) {
        Signos signos = new Signos();
        signos.setGlucosa(glucosa.getText().toString());
        signos.setHipertension(hipertension.getText().toString());
        signos.setIncardiaca(incardiaca.getText().toString());
        if (!signos.isNull()) {
            Toast.makeText(this, "ERROR: CAMPOS VACIOS", Toast.LENGTH_LONG).show();
        } else {
        }
            /*if(dao.inserUsuario(signos)){
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
            Intent i2 = new Intent(RegistrarSignos.this,MainActivity.class);
            startActivity(i2);
            finish();
            } else {
            Toast.makeText(this,"Usuario ya registrado", Toast.LENGTH_LONG).show();
            }*/

    }
}
