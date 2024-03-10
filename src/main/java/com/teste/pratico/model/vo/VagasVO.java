package com.teste.pratico.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VagasVO {

    private Long id;

    private Date inicio;

    private Date fim;

    private Integer quantidade;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public VagasVO() {
    }

    public VagasVO(Long id, Date inicio, Date fim, Integer quantidade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.quantidade = quantidade;
    }

    public String getDataInicioExibicao() {
        return dateFormat.format(this.inicio);
    }

    public String getDataFimExibicao() {
        return dateFormat.format(this.fim);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
