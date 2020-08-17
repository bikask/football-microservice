package com.sapient.football.exception;

public class TeamNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TeamNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TeamNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TeamNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TeamNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
