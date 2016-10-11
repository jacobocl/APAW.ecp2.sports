package es.jacobocl.sport.exceptions;

public class InvalidRequestException extends Exception {
    private static final long serialVersionUID = 3316523103457155813L;

    public static final String DESCRIPTION = "Petición no implementada";

    public InvalidRequestException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidRequestException() {
        this("");
    }

}
