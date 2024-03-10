package com.teste.pratico.model.vo;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendamentoVO {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String numero;

    private String motivo;

    private SolicitanteVO solicitante;

    public AgendamentoVO() {
    }

    public AgendamentoVO(Long id, Date data, String numero, String motivo, SolicitanteVO solicitante) {
        this.id = id;
        this.data = data;
        this.numero = numero;
        this.motivo = motivo;
        this.solicitante = solicitante;
    }

    public String getDataExibicao() {
        return dateFormat.format(this.data);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SolicitanteVO getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(SolicitanteVO solicitante) {
        this.solicitante = solicitante;
    }
}
