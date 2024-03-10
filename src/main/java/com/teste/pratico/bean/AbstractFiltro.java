package com.teste.pratico.bean;

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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "404", "Não foi encontrado resultado para sua consulta."));
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
