package homework2.exceptions;

public class InvalidMonthNumberException extends RuntimeException {

    public InvalidMonthNumberException() {

    }

    public InvalidMonthNumberException(String msgError) {
        super(msgError);
    }

}
