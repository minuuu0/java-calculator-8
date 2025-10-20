package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static final String REGEX = "//(.)\n(.*)";

    public double calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        expression = expression.replace("\\n", "\n");
        Matcher matcher = Pattern.compile(REGEX).matcher(expression);

        String delimeter = ",|:";
        String inputNumbers = expression;

        if (matcher.matches()) {
            delimeter += "|" + Pattern.quote(matcher.group(1));
            inputNumbers = matcher.group(2);
        }

        double sum = 0;
        for (String number : inputNumbers.split(delimeter)) {
            if (number.isBlank()) {
                continue;
            }
            try {
                double value = Double.parseDouble(number);
                validateInputRange(value);
                validateNumber(value);
                sum = addWithOverflowCheck(sum, value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }

    private void validateNumber(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputRange(double value) {
        if (Double.isInfinite(value)) {
            throw new IllegalArgumentException();
        }
    }

    private double addWithOverflowCheck(double sum, double value) {
        double result = sum + value;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException();
        }
        return result;
    }
}
