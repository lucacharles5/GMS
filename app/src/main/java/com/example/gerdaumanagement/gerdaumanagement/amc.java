package com.example.gerdaumanagement.gerdaumanagement;

import java.util.ArrayList;

/**
 * Created by Lucas on 29/06/2017.
 */

public class amc {

    public int id;
    private String nome;
    private String contratada;
    public String tipo;
    public String data;
    public String resultado;
    ArrayList<Integer> respostas = new ArrayList<>();
    public String respostasString;

    public String getRespostasString() {
        return respostasString;
    }

    public void setRespostasString(String respostasString) {
        this.respostasString = respostasString;
    }


    public ArrayList<Integer> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Integer> respostas) {
        this.respostas = respostas;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContratada() {
        return contratada;
    }

    public void setContratada(String terceira) {
        this.contratada = terceira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void getResultado(String resultado) {
        this.resultado = resultado;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Contratada : " +
                contratada + "Tipo: " + tipo + "Data: " + data;
    }

}

