package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
    Button btnEditar, btnEliminar, btnMostrar, btnSalir;
    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario  dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        nombre =(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btn_editar);
        btnEliminar=(Button)findViewById(R.id.btn_eliminar);
        btnMostrar=(Button)findViewById(R.id.btn_mostrar);
        btnSalir=(Button)findViewById(R.id.btn_salir);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+ u.getApellido());




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_editar:
                Intent i2 = new Intent(Inicio.this, Editar.class);

                startActivity(i2);
            break;
            case R.id.btn_eliminar:
                Intent i4 = new Intent(Inicio.this, MainActivity.class);

                startActivity(i4);
            break;
            case R.id.btn_salir:
            Intent r = new Intent(Inicio.this, MainActivity.class);

                startActivity(r);
                break;
            case R.id.btn_mostrar:
                Intent i3 = new Intent(Inicio.this, Mostrar.class);
                startActivity(i3);
                break;
        }

    }
}