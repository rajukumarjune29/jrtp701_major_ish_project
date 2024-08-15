package com.ish.ar.exception;

public class InvalidSSNException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidSSNException(String message) {
		super(message);
	}

}
