package expression.operator;

import expression.TripleExpression;


public class Multiply extends BinOperator {
    public Multiply(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right) {

        return left * right ;
    }
}