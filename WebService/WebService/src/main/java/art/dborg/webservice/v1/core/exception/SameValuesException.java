package art.dborg.webservice.v1.core.exception;

public class SameValuesException extends RuntimeException{
    public SameValuesException(String message) {
        super(message);
    }
}