package christmas.domain.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BonusEventManagerTest {

    private final BonusEventManager bonusEventManager = new BonusEventManager();

    @ParameterizedTest
    @DisplayName("makeBonusEventDiscount 메소드 테스트")
    @CsvSource(value = {
            "120000:25000",
            "148238:25000",
            "3000:0",
            "11111:0"
    }, delimiter = ':')
    void 증정_이벤트_총_혜택금액_테스트(int originalTotalAmount, int expected) {
        int bonusEventDiscount = bonusEventManager.makeBonusEventDiscount(originalTotalAmount);
        assertThat(bonusEventManager.makeBonusEventDiscount(originalTotalAmount)).isEqualTo(expected);
    }

}