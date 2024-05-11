package com.teste.pratico.view;

import com.teste.pratico.model.enums.ValidationErrorCode;
import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.AgendamentoVO;
import com.teste.pratico.service.AgendamentoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class AgendamentosManagedView {

    private final AgendamentoService agendamentoService;

    private final MessagesUtil messagesUtil;

    private AgendamentoVO agendamentoVO = new AgendamentoVO();

    private Date dataAtual = new Date();

    public void salvarAgendamento()
    {
        if (!agendamentoService.validarAgendamento(agendamentoVO)) {
            messagesUtil.renderWarnMessage("Erro na validação, causa: " + ValidationErrorCode.AGENDAMENTO_NAO_POSSUI_VAGAS.getCausa());
            return;
        }

        if (agendamentoVO.getId() != null) {
            agendamentoService.salvarAgendamento(agendamentoVO);
            messagesUtil.renderInfoPopup("SUCESSO", "Agendamento atualizado.");
        } else {
            agendamentoService.criarNovoAgendamento(agendamentoVO);
            messagesUtil.renderInfoMessage("Agendamento cadastrado com sucesso.");
        }

        clearAgendamentoVO();
    }

    public void clearAgendamentoVO() {
        agendamentoVO = new AgendamentoVO();
    }
}