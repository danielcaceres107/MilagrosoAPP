package com.example.milagrosoapp;

public class Usuario {
    int id, Temperatura;
    String Nombre, Apellido, Email, Password, Tipo, Sintomas, ActividadFisica, Medicamentos;

    public Usuario(){

    }

    public Usuario(int id, String nombre, String apellido, String email, String password, String tipo, int temperatura, String sintomas, String actividadFisica, String medicamentos) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
        Tipo = tipo;
        Temperatura = temperatura;
        Sintomas = sintomas;
        ActividadFisica = actividadFisica;
        Medicamentos = medicamentos;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Apellido.equals("")&&Email.equals("")&&Password.equals("")&&Tipo.equals("")){
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


    public int getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(int temperatura) {
        Temperatura = temperatura;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String sintomas) {
        Sintomas = sintomas;
    }

    public String getActividadFisica() {
        return ActividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        ActividadFisica = actividadFisica;
    }

    public String getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        Medicamentos = medicamentos;
    }
}
