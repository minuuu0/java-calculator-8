package calculator.domain;

public class Calculator {
    public int calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }
        return Integer.parseInt(expression);
    }
}
