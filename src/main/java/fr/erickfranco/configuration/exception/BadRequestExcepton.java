package fr.erickfranco.configuration.exception;

public class BadRequestExcepton extends RuntimeException {

	public BadRequestExcepton() {

	}

	public BadRequestExcepton(String message) {
		super(message);
	}

}
