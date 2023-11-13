package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuItemTest {

    @Nested
    class GetName {
        @ParameterizedTest
        @DisplayName("getName 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, BEVERAGE, 샴페인",
                "아이스크림, 5000, DESSERT, 아이스크림",
                "시저샐러드, 8000, APPETIZER, 시저샐러드",
        })
        void 메뉴아이템_이름을_잘_반환되는지_테스트(String name, int price, MenuType menuType, String expected) {
            MenuItem menuItem = new MenuItem(name, price, menuType);
            assertThat(menuItem.getName()).isEqualTo(expected);
        }
    }


}