package homework2.exceptions;

public class AgeRestriction extends RuntimeException {

    public AgeRestriction() {

    }

    public AgeRestriction(String msgError) {
        super(msgError);
    }

}
