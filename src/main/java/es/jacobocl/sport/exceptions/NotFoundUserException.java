package es.jacobocl.sport.exceptions;

public class NotFoundUserException extends Exception {

    private static final long serialVersionUID = 1049392026661480781L;

    public static final String DESCRIPTION = "Usuario no encontrado";

    public NotFoundUserException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public NotFoundUserException() {
        this("");
    }
}
