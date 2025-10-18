package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.presentation.ApplicationRunner;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationRunnerTest extends NsTest {
    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열을_입력할_경우_0을_반환() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).isEqualTo(expectedOutput(0));
        });
    }

    @Test
    void 숫자_하나를_입력할_경우_해당_숫자를_그대로_반환() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).isEqualTo(expectedOutput(1));
        });
    }

    @Test
    void 쉼표를_구분자로_사용하여_합_반환() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    @Test
    void 콜론을_구분자로_사용하여_합_반환() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    @Test
    void 쉼표와_콜론을_함께_사용하여_숫자들의_합_반환() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    private String expectedOutput(int result) {
        return INPUT_PROMPT + System.lineSeparator() + "결과 : " + result;
    }


    @Override
    public void runMain() {
        ApplicationRunner.main(new String[]{});
    }
}
