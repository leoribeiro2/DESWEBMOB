package br.com.leoribeiorweb.agendacomfirebase.model;

import com.google.firebase.database.Exclude;

/*
* Author: Leonardo Ribeiro
* RA: 816119319
* */
public class Contato {
    @Exclude
    private String id;
    private String nome;
    private String fone;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contato() {
    }

    public Contato(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public Contato(String id, String nome, String fone, String email) {
        this(nome, fone, email);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", fone='" + fone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
