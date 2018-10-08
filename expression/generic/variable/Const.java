package expression.generic.variable;

import expression.generic.TripleExpression;
import expression.generic.type.Type;

public class Const<T extends Number> implements TripleExpression<T> {

    private Type<T> val;

    public Const(Type<T> val) {
        this.val = val;
    }

    @Override
    public Type<T> evaluate(Type<T> x, Type<T> y, Type<T> z) {
        return val;
    }
}