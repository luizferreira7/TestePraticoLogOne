package com.teste.pratico.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Agendamento extends AbstractEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String numero;

    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;

    public Agendamento() {
    }

    public Agendamento(Date data, String numero, String motivo, Solicitante solicitante) {
        this.data = data;
        this.numero = numero;
        this.motivo = motivo;
        this.solicitante = solicitante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }
}
