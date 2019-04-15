package parser.operations.unary;

import parser.Expression;

public abstract class UnaryOperator implements Expression {
    private Expression val;

    UnaryOperator(Expression val) {
        this.val = val;
    }

    protected abstract int evaluateImpl(int val);

    @Override
    public int evaluate() {
        return evaluateImpl(val.evaluate());
    }
}