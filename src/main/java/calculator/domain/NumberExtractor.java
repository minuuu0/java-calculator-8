package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class NumberExtractor {

    public List<Double> extract(String numbers, String delimiterPattern) {
        return Arrays.stream(numbers.split(delimiterPattern))
                .filter(s -> !s.isBlank())
                .map(this::parseNumber)
                .toList();
    }

    private double parseNumber(String numberStr) {
        try {
            return Double.parseDouble(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
