package parser.token;

import java.util.ArrayList;
import java.util.List;


public class Tokenizer {
    private List<Token> tokens = new ArrayList<>();
    private int curr;
    private String expr;

    public Tokenizer(String expr) {
        this.expr = expr;
        curr = -1;
        tokenize();
        tokens.add(new Token(TokenType.END, "end of parser", expr.length()));
    }

    public boolean hasNext() {
        return curr < tokens.size() - 1;
    }

    public Token next() {
        return tokens.get(++curr);
    }

    public Token prev() {
        return tokens.get(--curr);
    }

    public Token current() {
        return tokens.get(curr);
    }

    public boolean isFirst() {
        return curr == 0;
    }

    private void tokenize() {
        for (int i = 0; i < expr.length(); i++) {
            if (Character.isWhitespace(expr.charAt(i))) {
                continue;
            }
            switch (expr.charAt(i)) {
                case '(':
                    tokens.add(new Token(TokenType.LEFT_BR, "(", i));
                    break;

                case ')':
                    tokens.add(new Token(TokenType.RIGHT_BR, ")", i));
                    break;

                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+", i));
                    break;

                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-", i));
                    break;

                case '*':
                    tokens.add(new Token(TokenType.MUL, "*", i));
                    break;

                case '/':
                    tokens.add(new Token(TokenType.DIV, "/", i));
                    break;

                case 'l':
                    i = genToken("log10", TokenType.LOG10, i);
                    break;

                case 'p':
                    i = genToken("pow10", TokenType.POW10, i);
                    break;

                case 'x':
                case 'y':
                case 'z':
                    tokens.add(new Token(TokenType.VARIABLE, String.valueOf(expr.charAt(i)), i));
                    break;

                default:
                    int j = i;
                    while (j < expr.length() && Character.isDigit(expr.charAt(j))) {
                        j++;
                    }
                    String number = expr.substring(i, j);
                    tokens.add(new Token(TokenType.CONST, number, i));
                    i = j - 1;
            }
        }
    }

    private int genToken(String token, TokenType type, int i) {
        int j = i + token.length();

        tokens.add(new Token(type, token, i));
        i += token.length() - 1;
        return i;
    }

}