package christmas.domain.entity;

import christmas.domain.entity.subclass.MockBonusMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BonusMenuTest {

    @Nested
    class GetTotalPrice {
        @ParameterizedTest
        @DisplayName("getTotalPrice 메소드 테스트")
        @CsvSource(value = {"ZERO_COLA, 6000", "SEAFOOD_PASTA,35000 ", "CHRISTMAS_PASTA, 25000"})
        void 증정_메뉴_하나_항목의_총가격_테스트(MockBonusMenu mockBonusMenu, int expected) {
            assertThat(expected).isEqualTo(mockBonusMenu.getTotalPrice());
        }
    }

    @Nested
    class GetTotalPriceForAllMenus {
        @Test
        @DisplayName("getTotalPriceForAllMenus 메소드 테스트")
        void 증정_메뉴전체의_총_가격_테스트() {
            int expected = 66000;
            assertThat(MockBonusMenu.getTotalPriceForAllMenus()).isEqualTo(expected);
        }
    }

    @Nested
    class GetName {
        @ParameterizedTest
        @DisplayName("getName 메소드 테스트")
        @CsvSource(value = {"ZERO_COLA,제로콜라", "SEAFOOD_PASTA,해산물파스타 ", "CHRISTMAS_PASTA,크리스마스파스타"})
        void 증정_메뉴이름이_잘_반환되는지_테스트(MockBonusMenu mockBonusMenu, String menuName) {
            assertThat(mockBonusMenu.getName()).isEqualTo(menuName);
        }
    }

}