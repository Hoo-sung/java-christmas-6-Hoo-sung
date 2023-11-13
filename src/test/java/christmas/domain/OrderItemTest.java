package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrderItemTest {

    @Nested
    class GetName {
        @ParameterizedTest
        @DisplayName("getName 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, BEVERAGE, 4, 샴페인",
                "아이스크림, 5000, DESSERT, 3, 아이스크림",
                "시저샐러드, 8000, APPETIZER, 7, 시저샐러드",
        })
        void 주문한_메뉴이름이_잘_반환되는지_테스트(String name, int price, MenuType menuType, int quantity, String expected) {
            MenuItem menuItem = new MenuItem(name, price, menuType);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            assertThat(orderItem.getName()).isEqualTo(expected);
        }
    }

    @Nested
    class GetQuantity {
        @ParameterizedTest
        @DisplayName("getQuantity 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, BEVERAGE, 4, 4",
                "아이스크림, 5000, DESSERT, 3, 3",
                "시저샐러드, 8000, APPETIZER, 7, 7",
        })
        void 주문한_메뉴_개수가_잘_반환되는지_테스트(String name, int price, MenuType menuType, int quantity, int expected) {
            MenuItem menuItem = new MenuItem(name, price, menuType);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            assertThat(orderItem.getQuantity()).isEqualTo(expected);
        }
    }

    @Nested
    class GetMenuType {
        @ParameterizedTest
        @DisplayName("getMenuType 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, BEVERAGE, 4, BEVERAGE",
                "아이스크림, 5000, DESSERT, 3, DESSERT",
                "시저샐러드, 8000, APPETIZER, 7, APPETIZER",
        })
        void 주문한_메뉴_타입이_잘_반환되는지_테스트(String name, int price, MenuType menuType, int quantity, MenuType expected) {
            MenuItem menuItem = new MenuItem(name, price, menuType);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            assertThat(orderItem.getMenuType()).isEqualTo(expected);
        }
    }

}