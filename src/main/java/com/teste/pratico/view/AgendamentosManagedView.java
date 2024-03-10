package com.teste.pratico.view;

import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class AgendamentosManagedView {

    @Autowired
    private AgendamentoService agendamentoService;

    private AgendamentoVO agendamentoVO = new AgendamentoVO();

    private Date dataAtual = new Date();

    public void salvarAgendamento() {
        agendamentoService.criaNovoAgendamento(agendamentoVO);
    }

    public AgendamentoVO getAgendamentoVO() {
        return agendamentoVO;
    }

    public void setAgendamentoVO(AgendamentoVO agendamentoVO) {
        this.agendamentoVO = agendamentoVO;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }
}