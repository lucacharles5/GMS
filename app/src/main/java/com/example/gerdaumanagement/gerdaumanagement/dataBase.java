package com.example.gerdaumanagement.gerdaumanagement;

/**
 * Created by Lucas on 19/06/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataBase extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "gerdauManagement.db";
   /* private static final String TABELA = "usuarios";
    private static final String NP  ="np";
    private static final String NOME  = "nome";
    private static final String TIPO_FUNC  = "tipoFunc";
    private static final String EMAIL = "email";
    private static final String SENHA_ACESSO = "senha_acesso";
    private static final String _ID = "_id";*/
    public static final int VERSAO = 10;

    public dataBase(Context context) {

        super(context, NOME_BANCO, null, VERSAO);
    }

   /* public dataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(_id integer primary key autoincrement, nome text not null, email text not null, np integer not null, tipoFunc text not null, senha text not null, login text not null);");
        db.execSQL("create table amc(_id integer primary key autoincrement, nome text not null, contratada text not null, tipo text not null, data text not null, respostas text not null, resultado real not null);");

        // id_usuario integer not null, FOREIGN KEY(id_usuario) REFERENCES usuarios(_id)");

        ContentValues admin = new ContentValues();
        admin.put("nome" , "admin");
        admin.put("email" , "lucacharles5@gmail.com");
        admin.put("np" , "00000000");
        admin.put("tipoFunc", "administradorSistema");
        admin.put("login" , "admin");
        admin.put("senha" , "administrador");
        db.insertOrThrow("usuarios", null, admin);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table usuarios";
        String sql1 = "drop table amc";

        db.execSQL(sql);
        db.execSQL(sql1);

        onCreate(db);

    }


}
