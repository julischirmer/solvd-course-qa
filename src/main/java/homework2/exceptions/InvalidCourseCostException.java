package homework2.exceptions;

public class InvalidCourseCostException extends Exception {

    public InvalidCourseCostException() {

    }

    public InvalidCourseCostException(String msgError) {
        super(msgError);
    }

}
