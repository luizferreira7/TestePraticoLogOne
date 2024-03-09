package com.teste.pratico.model.entity;

import javax.persistence.Entity;

@Entity
public class Solicitante extends AbstractEntity {

    private String nome;

    public Solicitante() {
    }

    public Solicitante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
