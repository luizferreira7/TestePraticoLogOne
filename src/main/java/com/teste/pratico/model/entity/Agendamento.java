package com.teste.pratico.model.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agendamento extends AbstractEntity {

    private Date data;

    private String numero;

    private String motivo;

    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;
}
