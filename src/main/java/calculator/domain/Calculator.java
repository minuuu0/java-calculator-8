package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static final String REGEX = "//(.)\n(.*)";

    public long calculate(String expression) {
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

        long sum = 0;
        for (String number : inputNumbers.split(delimeter)) {
            sum += Long.parseLong(number);
        }

        return sum;
    }
}
