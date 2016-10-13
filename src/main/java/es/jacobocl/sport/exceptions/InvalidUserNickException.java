package es.jacobocl.sport.exceptions;

public class InvalidUserNickException extends Exception {

    private static final long serialVersionUID = 6996511365836399376L;

    public static final String DESCRIPTION = "El nick del usuario no puede ser nulo";

    public InvalidUserNickException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidUserNickException() {
        this("");
    }
}
