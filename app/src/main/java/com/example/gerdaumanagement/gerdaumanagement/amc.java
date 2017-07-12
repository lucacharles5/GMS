package com.example.gerdaumanagement.gerdaumanagement;

import java.util.ArrayList;

/**
 * Created by Lucas on 29/06/2017.
 */

public class amc {

    public int id;
    private String nome;
    private String terceira;
    public String tipo;
    public String data;
    public String resultado;
    ArrayList<Integer> respostas = new ArrayList<>();


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

    public String getTerceira() {
        return terceira;
    }

    public void setTerceira(String terceira) {
        this.terceira = terceira;
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

    public void getResultado(String resposta) {
        this.resultado = resposta;
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
        return "Nome: " + nome + " Terceira : " +
                terceira + "Tipo: " + tipo + "Data: " + data;
    }

}

