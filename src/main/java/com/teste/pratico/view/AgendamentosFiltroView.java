package com.teste.pratico.view;

import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@ManagedBean
@ViewScoped
public class AgendamentosFiltroView extends AbstractFiltro<AgendamentoVO> {


    @Autowired
    private AgendamentoService agendamentoService;

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
    public void atualizaResultado() {
        setResultado(agendamentoService.findAgendamentosVO(inicio, fim));
    }

    public Date getDataAtual() {
        return dataAtual;
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
}
