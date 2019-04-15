package parser.operations.unary;

import parser.Expression;

public class Count extends UnaryOperator {
    public Count(Expression left) {
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
