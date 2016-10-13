package es.jacobocl.sport.exceptions;

public class InvalidUserEmailException extends Exception {
    
    private static final long serialVersionUID = -2735408586694342849L;

    public static final String DESCRIPTION = "El email del usuario no puede ser nulo";

    public InvalidUserEmailException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidUserEmailException() {
        this("");
    }
}
