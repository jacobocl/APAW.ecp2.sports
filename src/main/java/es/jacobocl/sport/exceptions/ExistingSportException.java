package es.jacobocl.sport.exceptions;

public class ExistingSportException extends Exception {

    private static final long serialVersionUID = -1834121133290234340L;
    
    public static final String DESCRIPTION = "Deporte existente";

    public ExistingSportException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public ExistingSportException() {
        this("");
    }
}
