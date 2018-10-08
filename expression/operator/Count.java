package expression.operator;

import expression.TripleExpression;

public class Count extends UnaryOperator {
    public Count(TripleExpression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) {
        return bitCounter(v);
    }

    private int bitCounter(int n) {

        return Integer.bitCount(n);
    }

}
