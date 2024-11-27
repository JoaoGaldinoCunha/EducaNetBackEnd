package br.com.school.educanet.exception;

public class LoginInvalidException extends Exception {
	public LoginInvalidException() {
	super("Login Invalido");
	}

	public LoginInvalidException(String message) {
		super(message);
	}

}
