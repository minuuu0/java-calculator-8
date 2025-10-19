package calculator.presentation;

public class ConsoleOutput {
    public void printResult(double result) {
        if (result == (long) result) {
            System.out.println("결과 : " + (long) result);
            return;
        }
        System.out.println("결과 : " + result);
    }
}
