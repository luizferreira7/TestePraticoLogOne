package com.teste.pratico.bean;

import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class VagasManagedBean {

    @Autowired
    private VagasService vagasService;

    private VagasVO vagasVO = new VagasVO();

    private Date dataAtual = new Date();

    public void salvarVagas() {
        vagasService.criaNovasVagas(vagasVO);
    }

    public List<VagasVO> getVagasAtivas() {
        return vagasService.recuperaTodasVagasAtivas();
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