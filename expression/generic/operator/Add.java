package expression.generic.operator;


import expression.generic.TripleExpression;
import expression.generic.type.Type;


public class Add<T extends Number> extends BinOperator<T> {
    public Add(TripleExpression<T> left, TripleExpression<T> right) {
        super(left, right);
    }

    @Override
    protected Type<T> evaluateImpl(Type<T> left, Type<T> right) {
        return left.add(right);
    }
}