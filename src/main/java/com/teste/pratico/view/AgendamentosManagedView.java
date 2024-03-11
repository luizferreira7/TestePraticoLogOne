package com.teste.pratico.view;

import com.teste.pratico.model.enums.ValidationErrorCode;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class AgendamentosManagedView {

    @Autowired
    private AgendamentoService agendamentoService;

    private AgendamentoVO agendamentoVO = new AgendamentoVO();

    private Date dataAtual = new Date();

    public void salvarAgendamento()
    {
        if (!agendamentoService.validarAgendamento(agendamentoVO)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getValor(),
                    "Erro na validação, causa: " + ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getCausa()));
            return;
        }

        agendamentoService.criaNovoAgendamento(agendamentoVO);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Agendamento cadastrado."));
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