package parser.variable;

import parser.Expression;

public class Const implements Expression {

    private int val;

    public Const(int val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return val;
    }
}