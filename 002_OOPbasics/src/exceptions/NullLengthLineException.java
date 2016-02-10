package exceptions;

public class NullLengthLineException extends Exception{
private String message;

public NullLengthLineException() {
	// TODO Auto-generated constructor stub
}

public NullLengthLineException(String message) {
	super(message);
}

@Override
	public String getMessage() {
		return super.getMessage();
	}
}
