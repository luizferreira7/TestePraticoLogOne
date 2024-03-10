package com.teste.pratico.view;

import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class SolicitantesManagedView {

    @Autowired
    private SolicitanteService solicitanteService;

    private SolicitanteVO solicitanteVO = new SolicitanteVO();


    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Solicitante cadastrado."));
    }

    public void salvarSolicitante() {
        solicitanteService.criaNovoSolicitante(solicitanteVO);
        info();
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
}
