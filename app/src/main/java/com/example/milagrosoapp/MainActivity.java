package com.example.milagrosoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario, clave;

    Button btn_ingresar, btn_registrar;
    daoUsuario dao;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        usuario =(EditText)findViewById(R.id.User);
        clave = (EditText)findViewById(R.id.clave);
        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        dao=new daoUsuario(this);



    }
    public void btn_ingresar (View view){
        String u=usuario.getText().toString();
        String p=clave.getText().toString();
        if(u.equals("")&&p.equals("")){
            Toast.makeText(this, "ERROR CAMPOS VACIOS",Toast.LENGTH_LONG).show();
        } else if (dao.login(u,p)==1) {
            Usuario ux=dao.getUsuario(u,p);
            Toast.makeText(this, " LOGIN EXITOSO",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this,RegistrarSignos.class);
            i.putExtra("id", ux.getId());
            startActivity(i);
        }else{
            Toast.makeText(this, " Usuario o clave incorrectos",Toast.LENGTH_LONG).show();
        }


    }
    public void btn_singupForm(View view){

        startActivity(new Intent(this,Registrar.class));
    }
}