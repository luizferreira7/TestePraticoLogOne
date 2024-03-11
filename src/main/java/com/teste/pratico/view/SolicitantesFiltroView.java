package com.teste.pratico.view;

import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class SolicitantesFiltroView extends  AbstractFiltro<SolicitanteVO> {

    @Autowired
    private SolicitanteService solicitanteService;

    private String nome;

    @Override
    public void atualizaResultado() {
        setResultado(solicitanteService.findSolicitantesVO(nome));
    }

    @Override
    public String cadastrar() {
        return "/solicitante/cadastroSolicitante.html";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
