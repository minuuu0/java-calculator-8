package calculator.domain;

public class NumberValidator {

    public void validate(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
