package com.teste.pratico.model.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Vagas extends AbstractEntity {

    private Date inicio;

    private Date fim;

    private Integer quantidade;

    public Vagas() {
    }

    public Vagas(Date inicio, Date fim, Integer quantidade) {
        this.inicio = inicio;
        this.fim = fim;
        this.quantidade = quantidade;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
