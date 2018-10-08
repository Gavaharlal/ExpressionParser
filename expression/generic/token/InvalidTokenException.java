package expression.generic.token;

import expression.generic.ParsingException;


class InvalidTokenException extends ParsingException {
    InvalidTokenException(String message, int idx) {
        super(String.format("unknown token %s at position %d", message, idx + 1));    }

    InvalidTokenException(char message, int idx) {
        super(String.format("unknown token %s at position %d", message, idx + 1));
    }
}