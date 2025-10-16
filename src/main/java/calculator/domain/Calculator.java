package calculator.domain;

public class Calculator {
    public int calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }
        throw new IllegalArgumentException();
    }
}
