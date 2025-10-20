package calculator;

import calculator.domain.Calculator;
import calculator.presentation.ConsoleInput;
import calculator.presentation.ConsoleOutput;

public class Application {

    private final ConsoleInput input;
    private final ConsoleOutput output;
    private final Calculator calculator;

    public Application() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.calculator = new Calculator();
    }

    public void run() {
        String inputString = input.readExpression();
        double result = calculator.calculate(inputString);
        output.printResult(result);
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
