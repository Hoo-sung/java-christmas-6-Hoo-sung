package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {


    @Nested
    class GetMenuItem {
        @ParameterizedTest
        @DisplayName("getMenuItem 테스트")
        @CsvSource({
                "CHAMPAGNE, 샴페인, 25000, BEVERAGE",
                "CHRISTMAS_PASTA, 크리스마스파스타, 25000, MAIN",
                "CAESAR_SALAD,시저샐러드,8000,APPETIZER"

        })
        void 메뉴_테스트(Menu menu, String expectedName, int expectedPrice, MenuType expectedType) {
            MenuItem menuItem = menu.getMenuItem();

            assertThat(menuItem.getName()).isEqualTo(expectedName);
            assertThat(menuItem.getPrice()).isEqualTo(expectedPrice);
            assertThat(menuItem.getType()).isEqualTo(expectedType);
        }
    }

}