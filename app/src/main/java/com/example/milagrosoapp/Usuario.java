package com.example.milagrosoapp;

public class Usuario {
    int id;
    String Nombre, Apellido, Email, Password;

    public Usuario(){

    }

    public Usuario(int id, String nombre, String apellido, String email, String password) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Apellido.equals("")&&Email.equals("")&&Password.equals("")){
            return false;
        }
        else {
            return true;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
