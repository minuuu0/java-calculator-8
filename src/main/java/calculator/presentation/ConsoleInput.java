package calculator.presentation;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public String readExpression() {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }
}
