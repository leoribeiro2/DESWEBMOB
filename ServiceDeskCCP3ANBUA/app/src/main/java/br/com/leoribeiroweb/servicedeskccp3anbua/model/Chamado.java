package br.com.leoribeiroweb.servicedeskccp3anbua.model;

import java.io.Serializable;

public class Chamado implements Serializable {
    private String tipo;
    private String nome;

    public Chamado(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.getTipo() + " : " + this.getNome();
    }
}
