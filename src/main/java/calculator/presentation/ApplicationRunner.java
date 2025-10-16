package calculator.presentation;

import calculator.domain.Calculator;

public class ApplicationRunner {

    private final ConsoleInput input;
    private final ConsoleOutput output;
    private final Calculator calculator;

    public ApplicationRunner() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.calculator = new Calculator();
    }

    public void run() {
        String inputString = input.readExpression();
        int result = calculator.calculate(inputString);
        output.printResult(result);
    }

    public static void main(String[] args) {
        new ApplicationRunner().run()
    }
}
