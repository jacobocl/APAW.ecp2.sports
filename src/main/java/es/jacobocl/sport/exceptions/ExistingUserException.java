package es.jacobocl.sport.exceptions;

public class ExistingUserException extends Exception {
    
    private static final long serialVersionUID = -1322684792639867619L;

    public static final String DESCRIPTION = "Usuario existente";

    public ExistingUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ExistingUserException() {
        this("");
    }
}
