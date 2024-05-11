package com.teste.pratico.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vagas extends AbstractEntity {

    private Date inicio;

    private Date fim;

    private Integer quantidade;
}
