package com.example.milagrosoapp;

public class Signos {
    int id;
    String Glucosa, Hipertension, Incardiaca, Temperatura, Sintomas, ActividadFisica, Medicamentos;

    public Signos(){

    }

    public Signos(int id, String glucosa, String hipertension, String incardiaca, String temperatura, String sintomas, String actividad_fisica, String medicamentos) {
        this.id = id;
        Glucosa = glucosa;
        Hipertension = hipertension;
        Incardiaca = incardiaca;
        Temperatura = temperatura;
        ActividadFisica = actividad_fisica;
        Medicamentos = medicamentos;
    }

    public boolean isNull(){
        if(Temperatura.equals("")&&Sintomas.equals("")&&ActividadFisica.equals("")&&Medicamentos.equals("")){
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

    public String getGlucosa() {
        return Glucosa;
    }

    public void setGlucosa(String glucosa) {
        Glucosa = glucosa;
    }

    public String getHipertension() {
        return Hipertension;
    }

    public void setHipertension(String hipertension) {
        Hipertension = hipertension;
    }

    public String getIncardiaca() {
        return Incardiaca;
    }

    public void setIncardiaca(String incardiaca) {
        Incardiaca = incardiaca;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String temperatura) {
        Temperatura = temperatura;
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
