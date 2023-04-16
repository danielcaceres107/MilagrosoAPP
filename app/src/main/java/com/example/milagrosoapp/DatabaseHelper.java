package com.example.milagrosoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Usuarios.db";
    public static final String TABLE_NAME="Registros_RapiCoop";
    public static final String COL1="ID";
    public static final String COL2="FULLNAME";
    public static final String COL3="USERNAME";
    public static final String COL4="EMAIL";
    public static final String COL5="PASSWORD";
    public static final String COL6="TIPO_USUARIO";
    public static final String COL7="DIRECCION";
    public static final String COL8="ANO_NACIMIENTO";
    public static final String COL9="GENERO";
    public static final String COL10="GLUCOSA";
    public static final String COL11="PRESION";
    public static final String COL12="FRECUENCIA";
    public static final String COL13="TEMPERATURA";
    public static final String COL14="SINTOMAS";
    public static final String COL15="ACTIVIDAD";
    public static final String COL16="MEDICAMENTOS";

    private static final String DB_NAME="RapiCoop";
    private static final int DB_VERSION=1;

    public DatabaseHelper (@Nullable Context context){
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "FULLNAME TEXT,USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT, TIPO_USUARIO TEXT, DIRECCION TEXT, ANO_NACIMIENTO TEXT, GENERO TEXT, GLUCOSA TEXT,PRESION TEXT, FRECUENCIA TEXT, TEMPERATURA TEXT, SINTOMAS TEXT, ACTIVIDAD TEXT, MEDICAMENTOS TEXT) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public void initData(){
        SQLiteDatabase db= this.getWritableDatabase();
        onUpgrade(db,1,1);
    }

    public boolean insertData(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2,user.getFullname());
        contentValues.put(COL3,user.getUserName());
        contentValues.put(COL4,user.geteMail());
        contentValues.put(COL5,user.getPassword());
        contentValues.put(COL6,user.getTipoPaciente());
        contentValues.put(COL7,user.getDireccion());
        contentValues.put(COL8,user.getano_nacimiento());
        contentValues.put(COL9,user.getGenero());
        contentValues.put(COL10,user.getGlucosa());
        contentValues.put(COL11,user.getPresion());
        contentValues.put(COL12,user.getFrecuencia());
        contentValues.put(COL13,user.getTemperatura());
        contentValues.put(COL14,user.getSintomas());
        contentValues.put(COL15,user.getActividad());
        contentValues.put(COL16,user.getMedicamentos());
        long result=db.insert(TABLE_NAME, null, contentValues);
        if(result==1)
            return false;
        else
            return true;
    }
    public Cursor getAlldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_NAME,null);
        return result;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" "+" where id=" +id+"",null);
        return res;
    }
    public Cursor getUser(String user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from"+TABLE_NAME+"where COL3="+user+"",null);
        return res;
    }
    public Cursor findDataByEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from"+TABLE_NAME+"where "+COL4+"= '"+email+"'",null);
        return res;
    }
    public void actualizarUser(String glucosa, String hipertension, String frecuenciaCardiaca, String temperatura, String sintomas, String actividadFisica, String medicamentos, int id ){
        SQLiteDatabase db = this.getReadableDatabase();

        String updateQuery = "UPDATE " + TABLE_NAME + " SET " + "GLUCOSA" + " = " + glucosa + ", "+ " PRESION" + " = " + hipertension + ", " + "FRECUENCIA" + " = " + frecuenciaCardiaca + ", " + "TEMPERATURA" + " = " + temperatura + ", " + "SINTOMAS" + " = " + sintomas + ", " + "ACTIVIDAD" + " = " + actividadFisica + ", " + "MEDICAMENTOS" + " = " + medicamentos + " WHERE " + "ID" + " = " + id;
        db.execSQL(updateQuery);


    }
}
