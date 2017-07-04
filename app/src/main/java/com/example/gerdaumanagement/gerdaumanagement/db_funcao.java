package com.example.gerdaumanagement.gerdaumanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 19/06/2017.
 */

public class db_funcao extends adicionar_usuario{
    private SQLiteDatabase db;


    public db_funcao (Context context){

        dataBase auxdb = new dataBase(context);
        db = auxdb.getReadableDatabase();
    }

    public void inserir (usuarioData usuario){

        ContentValues valores = new ContentValues();


        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("np", usuario.getNp());
        valores.put("senha", usuario.getSenha());
        valores.put("tipoFunc", usuario.getTipoFunc());
        valores.put("login", usuario.getLogin());

        db.insert("usuarios",null, valores);

    }

    public void atualizar (usuarioData usuario){

        ContentValues valores = new ContentValues();


        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("np", usuario.getNp());
        valores.put("senha", usuario.getSenha());
        valores.put("tipoFunc", usuario.getTipoFunc());
        valores.put("login", usuario.getLogin());

        db.update("usuarios",valores, "_id=?", new String[]{usuario.getId()+""});

    }

    public void deletar (usuarioData usuario){
        db.delete("usuarios", "_id = "+usuario.getId(), null);

    }

    public List<usuarioData> buscar(){
        List<usuarioData> list = new ArrayList<>();
        //String[] colunas = new String[]{"_id","nome","email","np","tipoFunc"};

        Cursor cursor = db.query("usuarios", null, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                usuarioData u = new usuarioData();

                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setNp(cursor.getString(3));
                u.setTipoFunc(cursor.getString(4));
                u.setSenha(cursor.getString(5));
                u.setLogin(cursor.getString(6));


                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }

    public int login(String username,String password)
    {

        String[] selectionArgs = new String[]{username, password};
        try
        {
            int i = 0;
            Cursor c = null;
            c = db.rawQuery("select login, senha from usuarios where login=? and senha=?", selectionArgs);
            c.moveToFirst();
            i = c.getCount();
            c.close();
            System.out.println("AQUIII " + i);
            return i;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }


    public String verificarUsuario(String login)
    {

        try
        {

        String selectQuery = "select nome from usuarios where login = '" + login + "'";



        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
            String nomeString = cursor.getString(cursor.getColumnIndex("nome"));

        StringBuilder conversor = new StringBuilder();
        conversor.append(nomeString);
        return conversor.toString();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }

    public String verificarCargo(String login)
    {

        try
        {

            String selectQuery = "select tipoFunc from usuarios where login = '" + login + "'";



            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            String nomeString = cursor.getString(cursor.getColumnIndex("tipoFunc"));

            StringBuilder conversor = new StringBuilder();
            conversor.append(nomeString);
            return conversor.toString();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }

    public void inserirAmc (amc amc){

        ContentValues valores = new ContentValues();

        valores.put("tipo", amc.getTipo());
        valores.put("item", amc.getItem());
        valores.put("questao", amc.getQuestao());
        valores.put("potencial", (byte) amc.getPotencial());
        valores.put("titulo", amc.getTitulo());


        db.insert("amc",null, valores);

    }


}
