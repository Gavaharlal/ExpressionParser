import expression.exceptions.ExpressionParser;
import expression.TripleExpression;
import expression.exceptions.ParsingException;

public class Main {

    public static void main(String[] args) throws ParsingException {

        ExpressionParser parser = new ExpressionParser();
        String expr = "2 + 4 - 5 * 2";
        TripleExpression res = parser.parse(expr);
        System.out.println(res.evaluate(0, 0, 0));
    }
}
