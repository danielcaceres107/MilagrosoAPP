package com.example.milagrosoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login_form extends AppCompatActivity {
    private DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login Form");
        myDb = new DatabaseHelper(Login_form.this);

        TextInputLayout userLayout = findViewById(R.id.user_login);
        EditText user = userLayout.getEditText();

        TextInputLayout passLayout = findViewById(R.id.user_password);
        EditText password = passLayout.getEditText();


        Button myButton = (Button) findViewById(R.id.usuario);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDb.getReadableDatabase();
                String query = "SELECT * FROM Registros_RapiCoop";
                Cursor cursor = db.rawQuery(query, null);
                String usuario1 = user.getText().toString();
                String clave = password.getText().toString();
                int validación=0;
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String usuario2 = cursor.getString(2);
                    String clave1 = cursor.getString(4);
                    String tipo = cursor.getString(5);
                    if (usuario1.equals(usuario2)&&clave1.equals(clave)) {
                        if(tipo.equals("Diabetes")){
                            Intent intent = new Intent(Login_form.this, signosDiabetes.class);
                            intent.putExtra("idUser", id);
                            startActivity(intent);
                            validación = validación++;
                            break;
                        } else if (tipo.equals("Hipertension")) {
                            Intent intent = new Intent(Login_form.this, signosHipertension.class);
                            intent.putExtra("idUser", id);
                            startActivity(intent);
                            validación = validación++;
                            break;
                        } else {
                            Intent intent = new Intent(Login_form.this, signosInsuficiencia.class);
                            intent.putExtra("idUser", id);
                            startActivity(intent);
                            validación = validación++;
                            break;
                        }
                    }

                }
                if (validación==0){
                    Toast.makeText(Login_form.this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    public void btn_singupForm(View view){

        startActivity(new Intent(this, Signup_Form.class));
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
