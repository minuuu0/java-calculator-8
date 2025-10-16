package calculator.presentation;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class ConsoleInput {
    public String readExpression() {
        System.out.println("계산할 식을 입력하세요.");
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            // 테스트 환경에서 run("") 시 예외를 빈 문자열로 처리
            return "";
        }
    }
}
