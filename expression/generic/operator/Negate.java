package expression.generic.operator;


import expression.generic.TripleExpression;
import expression.generic.type.Type;


public class Negate<T extends Number> extends UnaryOperator<T> {
    public Negate(TripleExpression<T> val) {
        super(val);
    }

    @Override
    protected Type<T> evaluateImpl(Type<T> val) {
        return val.negate();
    }
}