package com.teste.pratico.view;

import com.teste.pratico.model.enums.ValidationErrorCode;
import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class AgendamentosManagedView extends AbstractManagedView<AgendamentoVO> {

    private final AgendamentoService agendamentoService;

    private AgendamentoVO agendamentoVO = new AgendamentoVO();

    private Date dataAtual = new Date();

    public AgendamentosManagedView(MessagesUtil messagesUtil, AgendamentoService agendamentoService) {
        super(messagesUtil);
        this.agendamentoService = agendamentoService;
    }

    public void salvar()
    {
        if (!agendamentoService.validarAgendamento(agendamentoVO)) {
            getMessagesUtil().renderWarnMessage("Erro na validação, causa: " + ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getCausa());
            return;
        }

        if (agendamentoVO.getId() != null) {
            agendamentoService.salvarAgendamento(agendamentoVO);
            getMessagesUtil().renderInfoPopup("SUCESSO", "Agendamento atualizado.");
        } else {
            agendamentoService.criarNovoAgendamento(agendamentoVO);
            getMessagesUtil().renderInfoMessage("Agendamento cadastrado com sucesso.");
            getNovasEntidades().add(agendamentoVO);
        }
        clearAgendamentoVO();
    }

    public void clearAgendamentoVO() {
        agendamentoVO = new AgendamentoVO();
    }
}