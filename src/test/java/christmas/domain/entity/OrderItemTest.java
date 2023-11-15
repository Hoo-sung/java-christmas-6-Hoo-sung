package christmas.domain.entity;

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
                "샴페인, 4, 샴페인",
                "아이스크림, 3, 아이스크림",
                "시저샐러드, 7, 시저샐러드",
        })
        void 주문한_메뉴이름이_잘_반환되는지_테스트(String name, int quantity, String expected) {
            Menu menu = Menu.getMenuItemByName(name);
            OrderItem orderItem = new OrderItem(menu, quantity);
            assertThat(orderItem.getName()).isEqualTo(expected);
        }
    }

    @Nested
    class GetQuantity {
        @ParameterizedTest
        @DisplayName("getQuantity 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 4, 4",
                "아이스크림, 3, 3",
                "시저샐러드, 7, 7",
        })
        void 주문한_메뉴_개수가_잘_반환되는지_테스트(String name, int quantity, int expected) {
            Menu menu = Menu.getMenuItemByName(name);
            OrderItem orderItem = new OrderItem(menu, quantity);
            assertThat(orderItem.getQuantity()).isEqualTo(expected);
        }
    }

    @Nested
    class GetMenuType {
        @ParameterizedTest
        @DisplayName("getMenuType 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 4, BEVERAGE",
                "아이스크림, 3, DESSERT",
                "시저샐러드, 7, APPETIZER",
        })
        void 주문한_메뉴_타입이_잘_반환되는지_테스트(String name, int quantity, MenuType expected) {
            Menu menu = Menu.getMenuItemByName(name);
            OrderItem orderItem = new OrderItem(menu, quantity);
            assertThat(orderItem.getMenuType()).isEqualTo(expected);
        }
    }

    @Nested
    class GetTotalItemAmount {
        @ParameterizedTest
        @DisplayName("getTotalItemAmount 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 4, 100000",
                "아이스크림, 3, 15000",
                "시저샐러드, 7, 56000",
        })
        void 주문한_메뉴의_총가격이_잘_반환되는지_테스트(String name, int quantity, int expected) {
            Menu menu = Menu.getMenuItemByName(name);
            OrderItem orderItem = new OrderItem(menu, quantity);
            assertThat(orderItem.getTotalItemAmount()).isEqualTo(expected);
        }
    }

}