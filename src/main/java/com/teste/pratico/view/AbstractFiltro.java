package com.teste.pratico.view;

import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class AbstractFiltro<T> {

    private List<T> resultado;

    public abstract void preencherConsulta(T t);

    public abstract void clearFiltro();

    public abstract void atualizarResultado();

    public void consultar() {
        atualizarResultado();

        if (getResultado().isEmpty()) {
            notfound();
        }
    }

    public void notfound() {
        FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi encontrado nenhum resultado para sua consulta.", null));
    }

    public String cadastrar() {
        return "";
    }

    public void atualizarFiltroPosCadastro(T t) {
        this.preencherConsulta(t);
        this.atualizarResultado();
    }
}
