package christmas.domain.verifier;

import christmas.domain.verifier.subclass.VisitDateVerifierSubTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.system.ExceptionMessage.INVALID_DATE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VisitDateVerifierTest {

    private final VisitDateVerifierSubTest visitDateVerifierTest = new VisitDateVerifierSubTest();
    @ParameterizedTest
    @DisplayName("checkNumeric 메소드 테스트")
    @ValueSource(strings = {
            "hello",
            "238hfwe",
            "13a39",
            "12345k",
    })
    void 입력된_방문날짜가_숫자가_아닌경우(String input) {
        assertThatThrownBy(() -> visitDateVerifierTest.checkNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATE_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("checkRange 메소드 테스트")
    @ValueSource(strings = {
            "32",
            "-1",
            "37",
            "0",
    })
    void 방문날짜가_유효한_범위가_아닌경우(String input) {
        assertThatThrownBy(() -> visitDateVerifierTest.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATE_MESSAGE);
    }



}