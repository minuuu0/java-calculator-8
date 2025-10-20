package calculator.domain;

import calculator.dto.DelimiterInfo;
import java.util.List;

public class Calculator {

    private final DelimiterParser delimiterParser = new DelimiterParser();
    private final NumberExtractor numberExtractor = new NumberExtractor();
    private final NumberValidator numberValidator = new NumberValidator();

    public double calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        DelimiterInfo delimiterInfo = delimiterParser.parse(expression);
        List<Double> numbers = numberExtractor.extract(
                delimiterInfo.numbers(),
                delimiterInfo.delimiterPattern()
        );

        numbers.forEach(numberValidator::validate);

        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
