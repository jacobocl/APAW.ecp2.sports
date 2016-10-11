package es.jacobocl.sport.exceptions;

public class InvalidSportNameException extends Exception {

    private static final long serialVersionUID = 1848784605645988887L;

    public static final String DESCRIPTION = "El nombre del deporte no puede ser nulo";
    
    public InvalidSportNameException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidSportNameException() {
        this("");
    }
}
