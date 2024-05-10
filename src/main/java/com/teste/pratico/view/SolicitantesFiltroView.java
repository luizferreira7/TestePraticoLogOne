package com.teste.pratico.view;

import com.teste.pratico.model.vo.SolicitanteVO;
import com.teste.pratico.service.SolicitanteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class SolicitantesFiltroView extends  AbstractFiltro<SolicitanteVO> {

    private final SolicitanteService solicitanteService;

    private String nome;

    @Override
    public void atualizaResultado() {
        setResultado(solicitanteService.findSolicitantesVO(nome));
    }

    @Override
    public String cadastrar() {
        return "/solicitante/cadastroSolicitante.html";
    }
}
