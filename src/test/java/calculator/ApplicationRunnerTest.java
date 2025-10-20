package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void 일반_문자를_커스텀_구분자로_사용하여_숫자들의_합_반환() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    @Test
    void 숫자를_커스텀_구분자로_사용하여_숫자들의_합_반환() {
        assertSimpleTest(() -> {
            run("//7\\n172737");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    @Test
    void 점을_커스텀_구분자로_사용하여_숫자들의_합_반환() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).isEqualTo(expectedOutput(6));
        });
    }

    @ParameterizedTest
    @CsvSource({
            "'1,,3', 4",
            "'1.5,2.3', 3.8",
            "'1,2.5,3', 6.5",
            "//;\\n, 0",
            "'//;\\n1,2;3', 6",
            "'//*\\n1*2*3', 6",
            "'//;\\n1;2\\n;3', 6"
    })
    void 특수_케이스_처리하여_숫자들의_합_반환(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "//;",              // //로 시작하지만 \n 없음
            "//\\n1,2",         // //와 \n 사이에 구분자 없음
            "//;;\\n1;;2"        // //와 \n 사이에 구분자 2개 이상
    })
    void 커스텀_구분자_형식_오류가_발생하면_IllegalArgumentException_반환(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "-1,2,3",
            "0",
            "a,2,3",
    })
    void 숫자_값_오류가_발생하면_IllegalArgumentException_반환(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isExactlyInstanceOf(IllegalArgumentException.class)
        );
    }

    private String expectedOutput(int result) {
        return INPUT_PROMPT + System.lineSeparator() + "결과 : " + result;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
