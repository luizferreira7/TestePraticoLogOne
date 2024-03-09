package com.teste.pratico.controller;

import com.teste.pratico.model.entity.Vagas;
import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class VagasController {

    @Autowired
    private VagasService vagasService;

    private VagasVO vagasVO = new VagasVO();

    public void salvarVagas() {
        vagasService.criaNovasVagas(vagasVO);
    }

    public List<Vagas> getAll() {
        return vagasService.recuperaTodasVagas();
    }

    public VagasVO getVagasVO() {
        return vagasVO;
    }

    public void setVagasVO(VagasVO vagasVO) {
        this.vagasVO = vagasVO;
    }
}