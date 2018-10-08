package expression.generic.parser;

import expression.generic.ParsingException;
import expression.generic.TripleExpression;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser<T extends Number> {
    TripleExpression<T> parse(String expression) throws ParsingException;
}