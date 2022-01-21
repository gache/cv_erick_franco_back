package fr.erickfranco.configuration.exception;

public class DiplomaAlreadyExistException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public DiplomaAlreadyExistException(final String message) {
		super(message);
	}

	public DiplomaAlreadyExistException() {
		super();
	}

	@Override
	public String getCode() {
		return null;
	}

}
