package expression.operator;

import expression.TripleExpression;


public class And extends BinOperator {
    public And(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left & right;
    }
}