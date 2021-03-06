package SQLITE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gerdaumanagement.gerdaumanagement.adicionar_usuario;

import java.util.ArrayList;
import java.util.List;

import acessoWS.usuarioDAO;
import pojos.amc;
import pojos.usuarios;

/**
 * Created by Lucas on 19/06/2017.
 */

public class db_funcao extends adicionar_usuario {
    private SQLiteDatabase db;


    public db_funcao(Context context) {

        dataBase auxdb = new dataBase(context);
        db = auxdb.getReadableDatabase();
    }

    public void inserir(usuarios usuario) {

        ContentValues valores = new ContentValues();


        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("np", usuario.getNp());
        valores.put("senha", usuario.getSenha());
        valores.put("cargo", usuario.getCargo());
        valores.put("login", usuario.getLogin());


        db.insert("usuarios", null, valores);

    }

    public void atualizar(usuarios usuario) {

        ContentValues valores = new ContentValues();


        valores.put("nome", usuario.getNome());
        valores.put("email", usuario.getEmail());
        valores.put("np", usuario.getNp());
        valores.put("senha", usuario.getSenha());
        valores.put("cargo", usuario.getCargo());
        valores.put("login", usuario.getLogin());

        db.update("usuarios", valores, "_id=?", new String[]{usuario.getId() + ""});

    }

    public void deletar(usuarios usuario) {
        db.delete("usuarios", "_id = " + usuario.getId(), null);
        usuarioDAO dao = new usuarioDAO();

        dao.excluirUsuario(usuario.getId());

    }

    public List<usuarios> buscar() {
        List<usuarios> list = new ArrayList<>();
        //String[] colunas = new String[]{"_id","nome","email","np","tipoFunc"};

        Cursor cursor = db.query("usuarios", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToLast();

            do {

                usuarios u = new usuarios();

                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setEmail(cursor.getString(2));
                u.setNp(cursor.getString(3));
                u.setCargo(cursor.getString(4));
                u.setSenha(cursor.getString(5));
                u.setLogin(cursor.getString(6));


                list.add(u);

            } while (cursor.moveToPrevious());
        }

        return (list);
    }


    public List<String> buscarUsuarios() {
        List<String> nomes = new ArrayList<String>();
        String selectQuery = "select nome from usuarios";
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {

                String nomeString = cursor.getString(cursor.getColumnIndex("nome"));

                StringBuilder conversor = new StringBuilder();
                conversor.append(nomeString);

                nomes.add(conversor.toString());

            } while (cursor.moveToNext());

        }
        return nomes;
    }

    public int login(String username, String password) {

        String[] selectionArgs = new String[]{username, password};
        try {
            int i = 0;
            Cursor c = null;
            c = db.rawQuery("select login, senha from usuarios where login=? and senha=?", selectionArgs);
            c.moveToFirst();
            i = c.getCount();
            c.close();
            System.out.println("AQUIII " + i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public String verificarUsuario(String login) {

        try {

            String selectQuery = "select nome from usuarios where login = '" + login + "'";


            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            String nomeString = cursor.getString(cursor.getColumnIndex("nome"));

            StringBuilder conversor = new StringBuilder();
            conversor.append(nomeString);
            return conversor.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String verificarCargo(String login) {

        try {

            String selectQuery = "select cargo from usuarios where login = '" + login + "'";

            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            String nomeString = cursor.getString(cursor.getColumnIndex("cargo"));

            StringBuilder conversor = new StringBuilder();
            conversor.append(nomeString);
            return conversor.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void inserirAmc(amc dadosAmc) {

        ContentValues valores = new ContentValues();


        valores.put("nome", dadosAmc.getNome());
        valores.put("tipo", dadosAmc.getTipo());
        valores.put("data", dadosAmc.getData());
        valores.put("contratada", dadosAmc.getContratada());
        valores.put("respostas", dadosAmc.getRespostasString());
        valores.put("resultado", dadosAmc.getResultado());

        db.insert("amc", null, valores);

        amcNoMySQL(valores);

    }

    private void amcNoMySQL(ContentValues valores) {

        amc amcinseri = new amc();

        amcinseri.setNome(valores.getAsString("nome"));
        amcinseri.setTipo(valores.getAsString("tipo"));
        amcinseri.setData(valores.getAsString("data"));
        amcinseri.setContratada(valores.getAsString("contratada"));
        amcinseri.setRespostasString(valores.getAsString("respostas"));
        amcinseri.setResultado(valores.getAsFloat("resultado"));

        usuarioDAO dao = new usuarioDAO();
        dao.inserirAmc(amcinseri);
    }

    public List<amc> buscarAmc() {

        List<amc> list = new ArrayList<>();
        //String[] colunas = new String[]{"_id","nome","email","np","tipoFunc"};

        Cursor cursor = db.query("amc", null, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToLast();

            do {

                amc u = new amc();
                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setContratada(cursor.getString(2));
                u.setTipo(cursor.getString(3));
                u.setData(cursor.getString(4));
                u.setRespostasString(cursor.getString(5));
                u.setResultado(cursor.getDouble(6));
                list.add(u);

            } while (cursor.moveToPrevious());
        }

        return (list);
    }
}
