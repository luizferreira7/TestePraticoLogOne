package com.teste.pratico.model.vo;

import java.util.Date;

public class VagasVO {

    private String id;

    private Date inicio;

    private Date fim;

    private Integer quantidade;

    public VagasVO() {
    }

    public VagasVO(String id, Date inicio, Date fim, Integer quantidade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
