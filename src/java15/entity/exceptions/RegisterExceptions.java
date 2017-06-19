package java15.entity.exceptions;

public class RegisterExceptions extends Exception {

    protected String message;
    protected RegisterExceptions(String message)
    {
        this.message = message;
    }
}
