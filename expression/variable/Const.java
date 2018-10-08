package expression.variable;

import expression.TripleExpression;

public class Const implements TripleExpression {

    private int val;

    public Const(int val) {
        this.val = val;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return val;
    }
}