package es.jacobocl.sport.exceptions;

public class NotFoundUserException extends Exception {

    private static final long serialVersionUID = 954561180244291000L;

    public static final String DESCRIPTION = "Deporte no encontrado";

    public NotFoundUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public NotFoundUserException() {
        this("");
    }
}
