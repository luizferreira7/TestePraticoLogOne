package com.teste.pratico.view;

import com.teste.pratico.model.enums.ValidationErrorCode;
import com.teste.pratico.model.util.MessagesUtil;
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

    @Autowired
    protected MessagesUtil messagesUtil;

    private AgendamentoVO agendamentoVO = new AgendamentoVO();

    private Date dataAtual = new Date();

    public void salvarAgendamento()
    {
        if (!agendamentoService.validarAgendamento(agendamentoVO)) {
            messagesUtil.addMessageWarn(ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getValor(),
                    "Erro na validação, causa: " + ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getCausa(),
                    "msg");
            return;
        }

        if (agendamentoVO.getId() != null) {
            agendamentoService.salvarAgendamento(agendamentoVO);
            messagesUtil.addMessageInfo("SUCESSO", "Agendamento atualizado.", "popup");
        } else {
            agendamentoService.criaNovoAgendamento(agendamentoVO);
            messagesUtil.addMessageInfo("SUCESSO", "Agendamento cadastrado.", "msg");
        }

        clearAgendamentoVO();
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

    public void clearAgendamentoVO() {
        agendamentoVO = new AgendamentoVO();
    }
}