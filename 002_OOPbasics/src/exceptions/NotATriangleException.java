package exceptions;

public class NotATriangleException extends Exception{
private String message;

public NotATriangleException() {
	// TODO Auto-generated constructor stub
}

public NotATriangleException(String message) {
	super(message);
}

@Override
	public String getMessage() {
		return super.getMessage();
	}
}
