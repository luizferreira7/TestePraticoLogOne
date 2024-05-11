package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class SolicitantesManagedView {

    private final SolicitanteService solicitanteService;

    private final MessagesUtil messagesUtil;

    private SolicitanteVO solicitanteVO = new SolicitanteVO();

    public void salvarSolicitante() {
        if (solicitanteVO.getId() != null) {
            solicitanteService.salvarSolicitante(solicitanteVO);
            messagesUtil.renderInfoPopup("SUCESSO", "Solicitante atualizado.");
        } else{
            solicitanteService.criarNovoSolicitante(solicitanteVO);
            messagesUtil.renderInfoMessage("Solicitante cadastrado com sucesso.");
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
