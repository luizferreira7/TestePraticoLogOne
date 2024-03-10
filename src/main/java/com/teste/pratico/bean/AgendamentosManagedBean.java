package com.teste.pratico.bean;

import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.AgendamentoService;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class AgendamentosManagedBean {

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