package expression.parser;

import expression.TripleExpression;
import expression.exceptions.ParsingException;
import expression.operator.*;
import expression.token.Token;
import expression.token.TokenType;
import expression.token.Tokenizer;
import expression.variable.Const;
import expression.variable.Variable;

public class ExpressionParser implements Parser {
    private Tokenizer tokens;

    public TripleExpression parse(String expression) {
        try {
            tokens = new Tokenizer(expression);
        } catch (ParsingException e) {
            e.printStackTrace();
        }
        return expression();
    }

    private TripleExpression expression() {
        TripleExpression acc = or();

        if (tokens.hasNext()) {
            tokens.next();
        }

        return acc;
    }


    private TripleExpression or() {
        TripleExpression acc = xor();
        while (tokens.hasNext()) {
            Token operation = tokens.next();
            if (operation.getType() == TokenType.OR) {
                acc = new Or(acc, xor());
            } else {
                tokens.prev();
                return acc;
            }
        }
        return acc;
    }

    private TripleExpression xor() {
        TripleExpression acc = and();
        while (tokens.hasNext()) {
            Token operation = tokens.next();
            if (operation.getType() == TokenType.XOR) {
                acc = new Xor(acc, and());
            } else {
                tokens.prev();
                return acc;
            }
        }
        return acc;
    }

    private TripleExpression and() {
        TripleExpression acc = add();
        while (tokens.hasNext()) {
            Token operation = tokens.next();
            if (operation.getType() == TokenType.AND) {
                acc = new And(acc, add());
            } else {
                tokens.prev();
                return acc;

            }
        }
        return acc;
    }

    private TripleExpression add() {
        TripleExpression acc = mult();

        while (tokens.hasNext()) {
            Token operation = tokens.next();

            switch (operation.getType()) {
                case PLUS:
                    acc = new Add(acc, mult());
                    break;

                case MINUS:
                    acc = new Subtract(acc, mult());
                    break;

                default:
                    tokens.prev();
                    return acc;
            }
        }

        return acc;
    }

    private TripleExpression mult() {
        TripleExpression acc = primary();

        while (tokens.hasNext()) {
            Token operation = tokens.next();

            switch (operation.getType()) {
                case MUL:
                    acc = new Multiply(acc, primary());
                    break;

                case DIV:
                    acc = new Divide(acc, primary());
                    break;

                default:
                    tokens.prev();
                    return acc;
            }
        }

        return acc;
    }

    private TripleExpression primary() {
        Token token = tokens.next();
        TripleExpression primary = null;

        switch (token.getType()) {
            case CONST:
                primary = new Const(Integer.parseInt(token.getValue()));
                break;

            case VARIABLE:
                primary = new Variable(token.getValue());
                break;

            case MINUS:
                if (tokens.hasNext() && tokens.next().getType() == TokenType.CONST) {
                    Token number = tokens.current();
                    primary = new Const(Integer.parseInt("-" + number.getValue()));
                } else {
                    tokens.prev();
                    primary = new Negate(primary());
                }
                break;

            case LOGNOT:
                if (tokens.hasNext() && tokens.next().getType() == TokenType.CONST) {
                    Token number = tokens.current();
                    primary = new Const(~Integer.parseInt(number.getValue()));
                } else {
                    tokens.prev();
                    primary = new LogNot(primary());
                }
                break;

            case COUNT:
                if (tokens.hasNext() && tokens.next().getType() == TokenType.CONST) {
                    Token number = tokens.current();
                    primary = new Count(new Const(Integer.parseInt(number.getValue())));
                } else {
                    tokens.prev();
                    primary = new Count(primary());
                }
                break;
            case LEFT_BR:
                primary = expression();
                return primary;

            default:
                tokens.prev();

        }

        return primary;
    }
}