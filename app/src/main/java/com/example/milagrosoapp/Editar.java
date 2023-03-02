package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Editar extends AppCompatActivity {
    EditText editEmail, editNombre, editApellido, EditClave;
    Button btnActualizar, btnCancelar;
    int id=0;
    Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);
    }
}