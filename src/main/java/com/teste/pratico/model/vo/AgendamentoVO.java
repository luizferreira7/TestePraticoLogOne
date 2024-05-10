package com.teste.pratico.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AgendamentoVO {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    private String numero;

    private String motivo;

    private SolicitanteVO solicitante;

    public String getDataExibicao() {
        return dateFormat.format(this.data);
    }
}
