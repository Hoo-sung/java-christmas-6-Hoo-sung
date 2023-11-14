package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.Optional;

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
        void getMenuItem_테스트(Menu menu, String expectedName, int expectedPrice, MenuType expectedType) {
            MenuItem menuItem = menu.getMenuItem();

            assertThat(menuItem.getName()).isEqualTo(expectedName);
            assertThat(menuItem.getPrice()).isEqualTo(expectedPrice);
            assertThat(menuItem.getType()).isEqualTo(expectedType);
        }
    }

    @Nested
    class GetMenuItemByName {
        @ParameterizedTest
        @DisplayName("getMenuItemByName 테스트")
        @CsvSource({
                "샴페인, 샴페인, 25000, BEVERAGE",
                "크리스마스파스타, 크리스마스파스타, 25000, MAIN",
                "시저샐러드, 시저샐러드, 8000, APPETIZER",
        })
        void 메뉴_이름으로_메뉴아이템_찾는_테스트(String input, String expectedName, int expectedPrice, MenuType expectedType) {

            Optional<MenuItem> menuItemOptional = Menu.getMenuItemByName(input);
            menuItemOptional.ifPresent(menuItem -> {
                assertThat(menuItem.getName()).isEqualTo(expectedName);
                assertThat(menuItem.getPrice()).isEqualTo(expectedPrice);
                assertThat(menuItem.getType()).isEqualTo(expectedType);
            });
        }
    }

}