package com.teste.pratico.bean;

import com.teste.pratico.model.vo.VagasVO;
import com.teste.pratico.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class VagasFiltroBean extends AbstractFiltro<VagasVO> {

    @Autowired
    private VagasService vagasService;

    private final Date dataAtual = new Date();

    private Date inicio;

    private Date fim;

    @Override
    public String cadastrar() {
        return "/cadastroVagas.html";
    }

    @Override
    public void consultar() {
        setResultado(vagasService.findVagasVO(inicio, fim));
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
