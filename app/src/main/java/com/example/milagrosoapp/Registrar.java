package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registrar extends AppCompatActivity  {
    EditText email, nombre, apellido, clave;
    Button registrar, cancelar;

    Spinner spinnerTipo;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);
        email = (EditText) findViewById(R.id.correo);
        nombre = (EditText) findViewById(R.id.nombre2);
        apellido = (EditText) findViewById(R.id.apellido2);
        clave = (EditText) findViewById(R.id.clave);
        registrar = (Button) findViewById(R.id.button_registrar);
        cancelar = (Button) findViewById(R.id.btn_cancelar);

        spinnerTipo=findViewById(R.id.spinner_tipo);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinnerTipo.setAdapter(adapter);

        dao = new daoUsuario(this);

    }

    public void button_registrar (View view){
        Usuario user = new Usuario();
        user.setEmail(email.getText().toString());
        user.setNombre(nombre.getText().toString());
        user.setPassword(clave.getText().toString());
        user.setApellido(apellido.getText().toString());
        if(!user.isNull()){
            Toast.makeText(this,"ERROR: CAMPOS VACIOS", Toast.LENGTH_LONG).show();
        }else if(dao.inserUsuario(user)){
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
            Intent i2 = new Intent(Registrar.this,MainActivity.class);
            startActivity(i2);
            finish();
        }
        else{
            Toast.makeText(this,"Usuario ya registrado", Toast.LENGTH_LONG).show();
        }

    }
    public void btn_cancelar (View view){
        Intent i = new Intent(Registrar.this,MainActivity.class);
        startActivity(i);
        finish();

    }




}