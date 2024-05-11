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
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class AgendamentosFiltroView extends AbstractFiltro<AgendamentoVO> {

    private final AgendamentoService agendamentoService;

    private final Date dataAtual = new Date();

    private Date inicio;

    private Date fim;

    private String numero;

    private String motivo;

    @Override
    public String cadastrar() {
        return "/agendamento/cadastroAgendamento.html";
    }

    @Override
    public void preencherConsulta(AgendamentoVO agendamentoVO) {
        this.inicio = agendamentoVO.getData();
        this.fim = agendamentoVO.getData();
        this.numero = agendamentoVO.getNumero();
        this.motivo = agendamentoVO.getMotivo();
    }

    @Override
    public void clearFiltro() {
        setResultado(new ArrayList<>());
        this.inicio = null;
        this.fim = null;
        this.numero = null;
        this.motivo = null;
    }

    @Override
    public void atualizarResultado() {
        setResultado(agendamentoService.findAgendamentosVO(inicio, fim, numero, motivo));
    }
}
