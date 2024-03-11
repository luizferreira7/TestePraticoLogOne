package com.teste.pratico.view;

import com.teste.pratico.model.util.MessagesUtil;
import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class SolicitantesManagedView {

    @Autowired
    private SolicitanteService solicitanteService;

    @Autowired
    protected MessagesUtil messagesUtil;

    private SolicitanteVO solicitanteVO = new SolicitanteVO();

    public void salvarSolicitante() {
        if (solicitanteVO.getId() != null) {
            solicitanteService.salvarSolicitante(solicitanteVO);
            messagesUtil.addMessageInfo("SUCESSO", "Solicitante atualizado.", "popup");
        } else{
            solicitanteService.criaNovoSolicitante(solicitanteVO);
            messagesUtil.addMessageInfo("SUCESSO", "Solicitante cadastrado.", "msg");
        }
        clearSolicitanteVO();
    }

    public List<SolicitanteVO> completeSolicitante(String query) {

        return solicitanteService.findSolicitantesVO(query);
    }

    public SolicitanteVO getSolicitanteVO() {
        return solicitanteVO;
    }

    public void setSolicitanteVO(SolicitanteVO solicitanteVO) {
        this.solicitanteVO = solicitanteVO;
    }

    public void clearSolicitanteVO() {
        solicitanteVO = new SolicitanteVO();
    }
}
