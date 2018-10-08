package expression.generic.parser;


public class UnsupportedTypeException extends Exception {
    public UnsupportedTypeException(String message) {
        super("unsupported type" + message);
    }
}