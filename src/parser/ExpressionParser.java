package parser;

import parser.operations.binary.*;
import parser.operations.unary.Count;
import parser.operations.unary.LogNot;
import parser.operations.unary.Negate;
import parser.token.Token;
import parser.token.TokenType;
import parser.token.Tokenizer;
import parser.variable.Const;

public class ExpressionParser {
    private Tokenizer tokens;

    public Expression parse(String expression) {
        tokens = new Tokenizer(expression);
        return expression();
    }

    private Expression expression() {
        Expression acc = or();

        if (tokens.hasNext()) {
            tokens.next();
        }

        return acc;
    }


    private Expression or() {
        Expression acc = xor();
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

    private Expression xor() {
        Expression acc = and();
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

    private Expression and() {
        Expression acc = add();
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

    private Expression add() {
        Expression acc = mult();

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

    private Expression mult() {
        Expression acc = primary();

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

    private Expression primary() {
        Token token = tokens.next();
        Expression primary = null;

        switch (token.getType()) {
            case CONST:
                primary = new Const(Integer.parseInt(token.getValue()));
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