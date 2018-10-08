package expression.generic.variable;

import expression.generic.TripleExpression;
import expression.generic.type.Type;

public class Variable<T extends Number> implements TripleExpression<T> {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Type<T> evaluate(Type<T> x, Type<T> y, Type<T> z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
        }
        return null;
    }
}