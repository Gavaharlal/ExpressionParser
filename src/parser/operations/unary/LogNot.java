package parser.operations.unary;

import parser.Expression;

public class LogNot extends UnaryOperator {
    public LogNot(Expression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) {
        return ~v;
    }
}