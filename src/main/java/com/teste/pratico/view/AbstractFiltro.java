package com.teste.pratico.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public abstract class AbstractFiltro<T> {

    private List<T> resultado;

    public void consultar() {
        atualizaResultado();

        if (getResultado().isEmpty()) {
            notfound();
        }
    }

    public abstract void atualizaResultado();

    public void notfound() {
        FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, "Não foi encontrado nenhum resultado para sua consulta.", null));
    }

    public String cadastrar() {
        return "";
    }

    public List<T> getResultado() {
        return resultado;
    }

    public void setResultado(List<T> resultado) {
        this.resultado = resultado;
    }

}
