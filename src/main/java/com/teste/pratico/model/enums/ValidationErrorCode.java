package com.teste.pratico.model.enums;

import lombok.Getter;

@Getter
public enum ValidationErrorCode {

    AGENDAMENTO_NAO_POSSUI_VAGAS("A01", "Não existem vagas suficientes para o agendamento na data escolhida");

    private final String valor;

    private final String causa;

    ValidationErrorCode(String valor, String causa) {
        this.valor = valor;
        this.causa = causa;
    }
}
