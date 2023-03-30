package com.example.milagrosoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login_form extends AppCompatActivity {
    Button usuario;
    EditText user;
    EditText password;
    private DatabaseHelper myDb;
    private TextInputLayout getUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb = new DatabaseHelper(Login_form.this);
        user = (EditText) findViewById(R.id.user_login);
        password = (EditText) findViewById(R.id.user_password);
        usuario = (Button) findViewById(R.id.usuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");


    }
    public void btn_ingresar (View view){

        startActivity(new Intent(this,RegistrarSignos.class));
    }
    public void btn_singupForm(View view){

        startActivity(new Intent(this,Signup_Form.class));
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
