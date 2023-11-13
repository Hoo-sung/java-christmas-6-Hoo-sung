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

}