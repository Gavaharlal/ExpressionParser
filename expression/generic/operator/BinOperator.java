package expression.generic.operator;


import expression.generic.TripleExpression;
import expression.generic.type.Type;


public abstract class BinOperator<T extends Number> implements TripleExpression<T> {
    private TripleExpression<T> left;
    private TripleExpression<T> right;

    public BinOperator(TripleExpression<T> left, TripleExpression<T> right) {
        this.left = left;
        this.right = right;
    }

    protected abstract Type<T> evaluateImpl(Type<T> left, Type<T> right);

    @Override
    public Type<T> evaluate(Type<T> x, Type<T> y, Type<T> z) {
        return evaluateImpl(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }

}