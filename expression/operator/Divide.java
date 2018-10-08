package expression.operator;

import expression.TripleExpression;

public class Divide extends BinOperator {
    public Divide(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left / right;
    }
}