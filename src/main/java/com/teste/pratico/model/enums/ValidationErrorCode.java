package com.teste.pratico.model.enums;

public enum ValidationErrorCode {

    AGENDAMENTO_NAO_POSSUI_VAGAS("A01", "Não existem vagas suficientes para o agendamento na data escolhida");
    private String valor;

    private String causa;

    ValidationErrorCode(String valor, String causa) {
        this.valor = valor;
        this.causa = causa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
}
