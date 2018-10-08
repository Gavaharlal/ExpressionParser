package expression.operator.checked;

import expression.TripleExpression;
import expression.exceptions.OverflowException;
import expression.operator.UnaryOperator;


public class CheckedPow10 extends UnaryOperator {
    public CheckedPow10(TripleExpression left) {
        super(left);
    }

    @Override
    protected int evaluateImpl(int v) throws OverflowException {
        if (v < 0) {
            throw new IllegalArgumentException("pow10 " + v);
        }
        if (v >= 10) {
            throw new OverflowException("pow10", v);
        }
        int result = 1;
        for (int i = 0; i < v; i++) {
            result *= 10;
        }
        return result;
    }
}