package parser.operations.binary;

import parser.Expression;

public abstract class BinOperator implements Expression {
    private Expression leftOp;
    private Expression rightOp;

    BinOperator(Expression left, Expression right) {
        this.leftOp = left;
        this.rightOp = right;
    }

    protected abstract int evaluateImpl(int left, int right);

    @Override
    public int evaluate() {
        return evaluateImpl(leftOp.evaluate(), rightOp.evaluate());
    }

}