package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class SolicitantesManagedView extends AbstractManagedView<SolicitanteVO> {

    private final SolicitanteService solicitanteService;

    private SolicitanteVO solicitanteVO = new SolicitanteVO();

    public SolicitantesManagedView(MessagesUtil messagesUtil, SolicitanteService solicitanteService) {
        super(messagesUtil);
        this.solicitanteService = solicitanteService;
    }

    public void salvar() {
        if (solicitanteVO.getId() != null) {
            solicitanteService.salvarSolicitante(solicitanteVO);
            getMessagesUtil().renderInfoPopup("SUCESSO", "Solicitante atualizado.");
        } else{
            solicitanteService.criarNovoSolicitante(solicitanteVO);
            getMessagesUtil().renderInfoMessage("Solicitante cadastrado com sucesso.");
            getNovasEntidades().add(solicitanteVO);
        }
        clearSolicitanteVO();
    }

    public List<SolicitanteVO> completeSolicitante(String query) {

        return solicitanteService.findSolicitantesVO(query);
    }

    public void clearSolicitanteVO() {
        solicitanteVO = new SolicitanteVO();
    }
}
