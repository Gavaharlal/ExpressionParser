package expression.operator;

import expression.TripleExpression;


public class Subtract extends BinOperator {
    public Subtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left - right ;
    }
}