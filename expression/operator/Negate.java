package expression.operator;

import expression.TripleExpression;

public class Negate extends UnaryOperator {
    public Negate(TripleExpression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) {
        return -v;
    }
}