package expression.generic.parser;


import expression.generic.ParsingException;


public class ConstantOverflowException extends ParsingException {
    public ConstantOverflowException(String message) {
        super(String.format("constant overflow %s",message));
    }

    public ConstantOverflowException(String message, int idx) {
        super(String.format("constant overflow %s at position %d",message, idx + 1));
    }
}