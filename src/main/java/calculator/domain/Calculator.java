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
                continue;  // 연속된 구분자는 0으로 처리 (건너뛰기 = 0 추가와 동일)
            }
            try {
                sum += Double.parseDouble(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
