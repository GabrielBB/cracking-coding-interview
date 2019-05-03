package com.github.gabrielbb.practicing.codecompilation;

public class FailedCompilationException extends Exception {

	private static final long serialVersionUID = 1L;

	public FailedCompilationException(String message) {
		super(message);
	}
}