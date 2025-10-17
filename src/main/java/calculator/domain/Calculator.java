package calculator.domain;

public class Calculator {
    public long calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        String[] numbers = expression.split(",|:");

        long sum = 0;
        for (String number : numbers) {
            sum += Long.parseLong(number);
        }

        return sum;
    }
}
