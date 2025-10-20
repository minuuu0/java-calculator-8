package calculator.domain;

import calculator.dto.DelimiterInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITERS = ",|:";

    public DelimiterInfo parse(String expression) {
        if (expression.isBlank()) {
            return new DelimiterInfo(DEFAULT_DELIMITERS, expression);
        }

        String normalizedExpression = expression.replace("\\n", "\n");
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(normalizedExpression);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            String delimiterPattern = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
            return new DelimiterInfo(delimiterPattern, numbers);
        }

        return new DelimiterInfo(DEFAULT_DELIMITERS, normalizedExpression);
    }
}
