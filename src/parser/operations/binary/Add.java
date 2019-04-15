package parser.operations.binary;

import parser.Expression;


public class Add extends BinOperator {
    public Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    protected int evaluateImpl(int left, int right)  {
        return left + right;
    }
}