package com.teste.pratico.view;

import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class AgendamentosFiltroView extends AbstractFiltro<AgendamentoVO> {

    private final AgendamentoService agendamentoService;

    private final Date dataAtual = new Date();

    @Temporal(TemporalType.TIMESTAMP)

    private Date inicio;

    @Temporal(TemporalType.TIMESTAMP)

    private Date fim;

    @Override
    public String cadastrar() {
        return "/agendamento/cadastroAgendamento.html";
    }

    @Override
    public void atualizarResultado() {
        setResultado(agendamentoService.findAgendamentosVO(inicio, fim));
    }
}
