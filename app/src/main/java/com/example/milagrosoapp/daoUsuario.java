package com.example.milagrosoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context context;
    Usuario user;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String db="DBUsuarios";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";

    public daoUsuario(Context context){
        this.context=context;
        sql=context.openOrCreateDatabase(db, context.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        user= new Usuario();
    }
    public boolean inserUsuario(Usuario User){
        if(buscar(User.getEmail())==0){
            ContentValues contentValues= new ContentValues();
            contentValues.put("nombre",user.getNombre());
            contentValues.put("ap",user.getApellido());
            contentValues.put("usuario",user.getEmail());
            contentValues.put("pass",user.getPassword());
            return (sql.insert("usuario",null,contentValues)>0);
        }
        else {
            return false;
        }
    }

    public int buscar(String user){
        int x=0;
        lista=selectUsuario();
        for (Usuario us:lista){
            if(us.getEmail().equals(user)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario(){
        Cursor cursor=sql.rawQuery("select * from usuario", null );
        if (cursor!=null&&cursor.moveToFirst()){
            do{
                Usuario usuario=new Usuario();
                usuario.setId(cursor.getInt(0));
                usuario.setApellido(cursor.getString(4));
                usuario.setEmail(cursor.getString(1));
                usuario.setNombre(cursor.getString(3));
                usuario.setPassword(cursor.getString(2));
                lista.add(usuario);

            }
            while (cursor.moveToNext());
        }
        return lista;
    }
    public int login(String u, String p){
        int a=0;
        Cursor cursor=sql.rawQuery("select * from usuario", null);
        if(cursor!=null&&cursor.moveToFirst()){
            do{
                if(cursor.getString(1).equals(u)&&cursor.getString(2).equals(p)){
                    a++;
                }

            }while (cursor.moveToNext());


        }
        return a;
    }
    public  Usuario getUsuario(String u, String p){
        lista=selectUsuario();
        for (Usuario user:lista){
            if(user.getEmail().equals(u)&&user.getPassword().equals(p)){
                return user;
            }
        }
        return null;

    }
    public  Usuario getUsuarioById(int id){
        lista=selectUsuario();
        for (Usuario user:lista){
            if(user.getId()==id){
                return user;
            }
        }
        return null;

    }

}
