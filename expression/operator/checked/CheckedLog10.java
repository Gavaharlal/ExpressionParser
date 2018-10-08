package expression.operator.checked;

import expression.TripleExpression;
import expression.operator.UnaryOperator;

public class CheckedLog10 extends UnaryOperator {
    public CheckedLog10(TripleExpression val) {
        super(val);
    }

    @Override
    protected int evaluateImpl(int val) {
        if (val <= 0) {
            throw new IllegalArgumentException("log10 " + val);
        }
        int result = -1;
        while (val > 0) {
            val /= 10;
            result++;
        }
        return result;
    }
}