package com.teste.pratico.view;

import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ManagedBean
@ViewScoped
public class VagasFiltroView extends AbstractFiltro<VagasVO> {

    private final VagasService vagasService;

    private Date inicio;

    private Date fim;

    private Integer quantidade;

    @Override
    public String cadastrar() {
        return "/vagas/cadastroVagas.html";
    }

    @Override
    public void preencherConsulta(VagasVO vagasVO) {
        this.inicio = vagasVO.getInicio();
        this.fim = vagasVO.getFim();
        this.quantidade = vagasVO.getQuantidade();
    }

    @Override
    public void atualizarResultado() {
        setResultado(vagasService.findVagasVO(inicio, fim, quantidade));
    }

    @Override
    public void clearFiltro() {
        setResultado(new ArrayList<>());
        this.quantidade = null;
        this.inicio = null;
        this.fim = null;
    }

}
