package christmas.domain;

import christmas.domain.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Nested
    class getOrderItems {
        @ParameterizedTest
        @DisplayName("getOrderItems 메소드 테스트")
        @CsvSource(value = {
                "샴페인, 25000, BEVERAGE, 4",
                "아이스크림, 5000, DESSERT, 3",
                "시저샐러드, 8000, APPETIZER, 7",
        })
        void 주문내역을_잘_반환하는지_테스트(String name, int price, MenuType menuType, int quantity) {

            MenuItem menuItem = new MenuItem(name, price, menuType);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            Order order = new Order();
            order.addOrderItem(orderItem);

            List<OrderItem> orderItems = order.getOrderItems();

            assertThat(orderItems).containsExactly(orderItem);
        }
    }

    @Nested
    class getTotalOrderAmount {
        @ParameterizedTest
        @DisplayName("getTotalOrderAmount 메소드 테스트")
        @MethodSource("getTestData")
        void 총_주문_금액_합계를_잘_반환하는지_테스트(String menuInput, int totalOrderAmount) {
            Order order = Util.createOrderFromInput(menuInput);
            assertThat(order.getTotalOrderAmount()).isEqualTo(totalOrderAmount);
        }

        private static Stream<Arguments> getTestData() {
            return Stream.of(
                    Arguments.of("양송이수프-4,티본스테이크-1,제로콜라-3", 88000),
                    Arguments.of("타파스-3,해산물파스타-2,아이스크림-1", 91500),
                    Arguments.of("레드와인-2,시저샐러드-1,초코케이크-2", 158000)
            );
        }
    }
}