package com.teste.pratico.bean;

import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class VagasManagedBean {

    @Autowired
    private VagasService vagasService;

    private VagasVO vagasVO = new VagasVO();

    private Date dataAtual = new Date();

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Vagas cadastradas."));
    }

    public void salvarVagas() {
        vagasService.criaNovasVagas(vagasVO);
        info();
    }

    public VagasVO getVagasVO() {
        return vagasVO;
    }

    public void setVagasVO(VagasVO vagasVO) {
        this.vagasVO = vagasVO;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }
}