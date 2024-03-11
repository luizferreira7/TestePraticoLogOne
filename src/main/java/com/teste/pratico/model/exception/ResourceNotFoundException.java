package com.teste.pratico.model.exception;


import javax.faces.application.FacesMessage;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5734873068561247798L;

	public static final String MSGPADRAO = "Não foi possível completar a solicitação: recurso não encontrado";

	public ResourceNotFoundException()
	{
		super(MSGPADRAO);
	}

	public ResourceNotFoundException(String campo, String valor)
	{
		super("Não foi possível completar a solicitação, recurso: " + campo + " com valor: " + valor + ", não encontrado");
	}
}
