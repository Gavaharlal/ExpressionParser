package parser.operations.unary;

import parser.Expression;

public class Negate extends UnaryOperator {
    public Negate(Expression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) {
        return -v;
    }
}