package christmas.domain.verifier;

import christmas.domain.Order;
import christmas.domain.util.Util;
import christmas.domain.verifier.subclass.RuntimeVerifierSubTest;
import christmas.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RuntimeVerifierTest {

    private final RuntimeVerifierSubTest runtimeVerifierTest = new RuntimeVerifierSubTest();


    @ParameterizedTest
    @DisplayName("checkOrderQuantity 메소드 테스트")
    @ValueSource(strings = {
            "타파스-1,제로콜라-2,해산물파스타-7,양송이수프-10,초코케이크-1",
            "레드와인-7,샴페인-9,제로콜라-11",
            "시저샐러드-7,바비큐립-8,아이스크림-9",
    })
    void 주문한_메뉴의_개수가_20개를_초과한_경우(String input) {
        Order order = Util.createOrderFromInput(input);
        assertThatThrownBy(() -> runtimeVerifierTest.checkOrderQuantity(order))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ExceptionMessage.MAX_ORDER_QUANTITY_EXCEEDED_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("checkBeverageOnly 메소드 테스트")
    @ValueSource(strings = {
            "제로콜라-2,레드와인-4,샴페인-3",
            "레드와인-7,샴페인-1",
            "제로콜라-3",
    })
    void 음료만_주문한_경우(String input) {
        Order order = Util.createOrderFromInput(input);
        assertThatThrownBy(() -> runtimeVerifierTest.checkBeverageOnly(order))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ExceptionMessage.BEVERAGE_ONLY_ORDER_MESSAGE);
    }
}