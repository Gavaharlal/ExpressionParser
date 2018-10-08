package expression.operator;

import expression.TripleExpression;

public abstract class BinOperator implements TripleExpression {
    private TripleExpression leftOp;
    private TripleExpression rightOp;

    public BinOperator(TripleExpression left, TripleExpression right) {
        this.leftOp = left;
        this.rightOp = right;
    }

    protected abstract int evaluateImpl(int left, int right);

    @Override
    public int evaluate(int x, int y, int z) {
        return evaluateImpl(leftOp.evaluate(x, y, z), rightOp.evaluate(x, y, z));
    }

}