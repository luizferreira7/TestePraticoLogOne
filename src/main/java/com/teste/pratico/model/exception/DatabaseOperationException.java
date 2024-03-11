package com.teste.pratico.model.exception;

public class DatabaseOperationException extends RuntimeException {

	private static final long serialVersionUID = 5017102767488663934L;

	public static final String DEFAULT_MSG = "Não foi possível realizar operação no banco de dados";

	public DatabaseOperationException(Exception e)
	{
		super(DEFAULT_MSG);
	}
}
