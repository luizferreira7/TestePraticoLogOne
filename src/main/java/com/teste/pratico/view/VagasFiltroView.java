package com.teste.pratico.view;

import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
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

    @Override
    public String cadastrar() {
        return "/vagas/cadastroVagas.html";
    }

    @Override
    public void atualizaResultado() {
        setResultado(vagasService.findVagasVO(inicio, fim));
    }

}
