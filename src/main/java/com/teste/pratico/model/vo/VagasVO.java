package com.teste.pratico.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VagasVO {

    private Long id;

    private Date inicio;

    private Date fim;

    private Integer quantidade;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public String getDataInicioExibicao() {
        return dateFormat.format(this.inicio);
    }

    public String getDataFimExibicao() {
        return dateFormat.format(this.fim);
    }
}
