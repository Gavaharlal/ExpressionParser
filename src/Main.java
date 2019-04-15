import parser.Expression;
import parser.ExpressionParser;

public class Main {

    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        String expr = "2 + 4 - (5 - 6)* 2";
        Expression res = parser.parse(expr);
        System.out.println(res.evaluate());
    }
}
