package homework2.exceptions;

public class InvalidMailException extends Exception {

    public InvalidMailException() {

    }

    public InvalidMailException(String msgError) {
        super(msgError);
    }

}
