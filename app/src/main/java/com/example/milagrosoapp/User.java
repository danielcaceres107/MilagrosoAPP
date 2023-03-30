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
    private String temperatura;
    private String sintomas;
    private String actividadFisica;
    private String medicamentos;



    public User(String fullName, String userName, String email, String clave, String tipoPaciente, String direccion, String genero, int ano_nacimiento, String temperatura, String sintomas, String actividadFisica,String medicamentos) {
        fullName=new String();
        userName=new String();
        email=new String();
        clave=new String();
        tipoPaciente =new String();
        direccion=new String();
        ano_nacimiento=new Integer(0);
        genero=new String();
        temperatura=new String();
        sintomas=new String();
        actividadFisica=new String();
        medicamentos=new String();

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

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}
