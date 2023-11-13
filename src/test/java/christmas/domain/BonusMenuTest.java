package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusMenuTest {

    @Nested
    class GetTotalPriceForAllMenus {

        @Test
        @DisplayName("getTotalPrice 메소드 테스트")
        void 증정_메뉴_하나_항목의_총가격_테스트() {
            int expected = BonusMenu.CHAMPAGNE.getTotalPrice();
            assertThat(expected).isEqualTo(25000);
        }

        @Test
        @DisplayName("getTotalPriceForAllMenus 메소드 테스트")
        void 증정_메뉴전체의_총_가격_테스트() {
            int expected = BonusMenu.CHAMPAGNE.getTotalPrice();
            assertThat(BonusMenu.getTotalPriceForAllMenus()).isEqualTo(expected);
        }
    }

    @Nested
    class GetName {
        @Test
        @DisplayName("getName 메소드 테스트")
        void 증정_메뉴이름이_잘_반환되는지_테스트() {
            String expected = "샴페인";
            assertThat(BonusMenu.CHAMPAGNE.getName()).isEqualTo(expected);
        }
    }

    @Nested
    class GetQuantity {
        @Test
        @DisplayName("getQuantity 메소드 테스트")
        void 증정_메뉴가격이_잘_반환되는지_테스트() {
            int expected = 1;
            assertThat(BonusMenu.CHAMPAGNE.getQuantity()).isEqualTo(expected);
        }
    }

}