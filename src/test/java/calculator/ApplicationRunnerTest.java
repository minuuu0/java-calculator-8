package calculator;

import calculator.presentation.ApplicationRunner;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationRunnerTest extends NsTest {
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
            run("");
            assertThat(output()).isEqualTo("덧셈할 문자열을 입력해 주세요." + System.lineSeparator() + "결과 : 0");
        });
    }

    @Test
    void 숫자_하나를_입력할_경우_해당_숫자를_그대로_반환() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).isEqualTo("덧셈할 문자열을 입력해 주세요." + System.lineSeparator() + "결과 : 1");
        });
    }

    @Override
    public void runMain() {
        ApplicationRunner.main(new String[]{});
    }
}
