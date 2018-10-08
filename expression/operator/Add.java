package expression.operator;

import expression.TripleExpression;


public class Add extends BinOperator {
    public Add(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left + right;
    }
}