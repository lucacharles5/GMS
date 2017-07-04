package com.example.gerdaumanagement.gerdaumanagement;

import java.util.Date;

/**
 * Created by Lucas on 29/06/2017.
 */

public class amc {
    public int id;
    public String tipo;
    public String item;
    public String questao;
    public char potencial;
    public String titulo;
    public Date data;
    public String resposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }


    public String getQuestao() {

        return questao;
    }

    public void setQuestao(String questao) {

        this.questao = questao;
    }

    public char getPotencial() {

        return potencial;
    }

    public void setPotencial(char potencial) {

        this.potencial = potencial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Questao: " + questao + " Potencial: " +
                potencial + "Titulo: " + titulo + "Resposta: " + resposta + "Item: " + item + "Tipo: " + tipo;
    }

}

