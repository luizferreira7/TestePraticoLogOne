package com.teste.pratico.bean;

import java.util.List;

public abstract class AbstractFiltro<T> {

    private List<T> resultado;

    public abstract void consultar();

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
