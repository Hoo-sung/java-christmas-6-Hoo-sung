package christmas.domain.entity;

import christmas.domain.entity.BonusItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BonusItemTest {


    @Nested
    class GetName {
        @ParameterizedTest
        @DisplayName("getName 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, 1,샴페인",
                "아이스크림, 5000,3,아이스크림",
                "시저샐러드, 8000, 1,시저샐러드",
        })
        void 증정_메뉴이름이_잘_반환되는지_테스트(String name, int price, int quantity, String expected) {
            BonusItem bonusItem = new BonusItem(name, price, quantity);
            assertThat(bonusItem.getName()).isEqualTo(expected);
        }
    }

    @Nested
    class GetQuantity {
        @ParameterizedTest
        @DisplayName("getQuantity 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, 1,1",
                "아이스크림, 5000,3,3",
                "시저샐러드, 8000, 1,1",
        })
        void 증정_메뉴수량이_잘_반환되는지_테스트(String name, int price, int quantity, int expected) {
            BonusItem bonusItem = new BonusItem(name, price, quantity);
            assertThat(bonusItem.getQuantity()).isEqualTo(expected);
        }
    }

    @Nested
    class GetTotalItemPrice {
        @ParameterizedTest
        @DisplayName("getTotalPrice 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, 1, 25000",
                "아이스크림, 5000, 3, 15000",
                "시저샐러드, 8000, 2, 16000",
        })
        void 증정_메뉴_한품목의_총_가격을_잘_반환하는지_테스트(String name, int price, int quantity, int expected) {
            BonusItem bonusItem = new BonusItem(name, price, quantity);
            assertThat(bonusItem.getTotalPrice()).isEqualTo(expected);
        }
    }

}