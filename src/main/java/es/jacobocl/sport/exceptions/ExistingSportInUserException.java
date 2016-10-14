package es.jacobocl.sport.exceptions;

public class ExistingSportInUserException extends Exception {
    
    private static final long serialVersionUID = 111178392490669600L;

    public static final String DESCRIPTION = "Este deporte ya había sido añadido al usuario";

    public ExistingSportInUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ExistingSportInUserException() {
        this("");
    }
}
