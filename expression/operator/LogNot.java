package expression.operator;

import expression.TripleExpression;

public class LogNot extends UnaryOperator {
    public LogNot(TripleExpression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) {
        return ~v;
    }
}