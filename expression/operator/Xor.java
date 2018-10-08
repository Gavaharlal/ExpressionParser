package expression.operator;

import expression.TripleExpression;


public class Xor extends BinOperator {
    public Xor(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left ^ right;
    }
}