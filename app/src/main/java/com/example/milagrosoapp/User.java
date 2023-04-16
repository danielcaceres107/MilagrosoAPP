package com.example.milagrosoapp;

public class User {
    private String fullName;
    private String userName;
    private String email;
    private String clave;
    private String tipoPaciente;
    private String direccion;
    private int ano_nacimiento;
    private String genero;
    private String glucosa;
    private String presion;
    private String frecuencia;
    private String temperatura;
    private String sintomas;
    private String actividad;
    private String medicamentos;



    public User(String fullName, String userName, String email, String clave, String tipoPaciente, String direccion, String genero, int ano_nacimiento, String glucosa, String presion, String frecuencia, String temperatura, String sintomas,String actividad,String medicamentos) {
        fullName=new String();
        userName=new String();
        email=new String();
        clave=new String();
        tipoPaciente =new String();
        direccion=new String();
        ano_nacimiento=new Integer(0);
        genero=new String();
        glucosa =new String();
        presion =new String();
        frecuencia =new String();
        temperatura =new String();
        sintomas = new String();
        actividad = new String();
        medicamentos = new String();

    }
    public User() {

    }
    public void setFullName(String name)
    {
        fullName = name;
    }
    public void setUserName(String userName1)
    {
        userName = userName1;
    }
    public void setEmail(String email1)
    {
        email = email1;
    }
    public void setPassword(String password)
    {
        clave = password;
    }
    public void setRol(String rol) {
        tipoPaciente = rol;}
    public void setDireccion(String direccion1)
    {
        direccion=direccion1;
    }
    public void setAno_nacimiento(int tipo1)
    {
        ano_nacimiento = tipo1;
    }
    public void setGenero(String genero1) {genero = genero1;}
    public void setGlucosa(String glucosa1) {glucosa = glucosa1;}
    public void setPresion(String presion1) {
        presion = presion1;
    }
    public void setFrecuencia(String frecuencia1) {frecuencia = frecuencia1;}
    public void setTemperatura(String temperatura1) {
        temperatura = temperatura1;
    }
    public void setSintomas(String sintomas1) {sintomas = sintomas1;}
    public void setActividad(String actividad1) {actividad = actividad1;}
    public void setMedicamentos(String medicamentos1) {medicamentos = medicamentos1;}


    public String getFullname() {
        return this.fullName;
    }
    public String getUserName() {
        return this.userName;
    }
    public String geteMail() {
        return this.email;
    }
    public String getPassword() {
        return this.clave;
    }
    public String getTipoPaciente() {
        return this.tipoPaciente;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public  int getano_nacimiento() {
        return this.ano_nacimiento;
    }
    public String getGenero() {return this.genero;}
    public String getGlucosa() {
        return this.glucosa;
    }
    public String getPresion() {
        return this.presion;
    }
    public String getFrecuencia() {
        return this.frecuencia;
    }
    public String getTemperatura() {return this.temperatura;}
    public String getSintomas() {return this.sintomas;}
    public String getActividad() {return this.actividad;}
    public String getMedicamentos() {return this.medicamentos;}


}
