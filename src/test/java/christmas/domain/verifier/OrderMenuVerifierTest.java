package christmas.domain.verifier;

import christmas.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderMenuVerifierTest {

    private final OrderMenuVerifier orderMenuVerifier = new OrderMenuVerifier();


    @ParameterizedTest
    @DisplayName("checkMenuFormat 메소드 테스트")
    @ValueSource(strings = {
            "타파스-1, 제로콜라-2",
            "타파스 -1,제로칼라-2",
            "타파스-1,제로콜라 -2",
            "타파스-1,제로콜라-2 ",
    })
    void 메뉴형식에_맞는_입력이_아닌경우(String input) {
        assertThatThrownBy(() -> orderMenuVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ORDER_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("checkMenuExistence 메소드 테스트")
    @ValueSource(strings = {
            "양쏭이수프-1,제로콜라-2",
            "치킨샐러드-3,바비큐립-7",
            "콜라-1,레드와인-2",
            "타빠스-1,제로콜라-2 ",
    })
    void 메뉴판에_없는_입력인_경우(String input) {
        assertThatThrownBy(() -> orderMenuVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ORDER_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("checkDistinctMenu 메소드 테스트")
    @ValueSource(strings = {
            "양송이수프-1,양송이수프-2",
            "티본스테이크-1,바비큐립-1,초코케이크-2,티본스테이크-1",
            "제로콜라-1,레드와인-2,제로콜라-3",
            "레드와인-1,제로콜라-2,레드와인-4",
    })
    void 중복된_메뉴_입력이_주어진_경우(String input) {
        assertThatThrownBy(() -> orderMenuVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ORDER_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("checkMenuQuantity 메소드 테스트")
    @ValueSource(strings = {
            "타파스-1,제로콜라-3,레드와인-0",
            "티본스테이크-1,바비큐립-1,초코케이크-0",
            "제로콜라-1,레드와인-2,아이스크림-0",
            "레드와인-0,시저샐러드-2,초코케이크-4",
    })
    void 메뉴의_개수가_1이상의_숫자가_아닌경우(String input) {
        assertThatThrownBy(() -> orderMenuVerifier.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ORDER_MESSAGE);
    }

}