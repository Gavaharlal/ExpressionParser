package expression.generic.operator;

import expression.generic.TripleExpression;
import expression.generic.type.Type;


public class Abs<T extends Number> extends UnaryOperator<T> {
    public Abs(TripleExpression<T> val) {
        super(val);
    }

    @Override
    protected Type<T> evaluateImpl(Type<T> val) {
        return val.abs();
    }
}