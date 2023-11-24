package christmas.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Nested
    class getOrderItems {
        @ParameterizedTest
        @DisplayName("getOrderItems 메소드 테스트")
        @MethodSource("getTestData")
        void 주문내역을_잘_반환하는지_테스트(String input, List<OrderItem> expected) {
            Order order = Order.create(input);
            List<OrderItem> orderItems = order.getOrderItems();
            assertThat(orderItems).usingRecursiveFieldByFieldElementComparator().containsExactlyElementsOf(expected);
        }

        private static Stream<Arguments> getTestData() {
            return Stream.of(
                    Arguments.of("샴페인-4,양송이수프-3", List.of(new OrderItem(Menu.CHAMPAGNE, 4), new OrderItem(Menu.MUSHROOM_SOUP, 3))),
                    Arguments.of("아이스크림-3,타파스-2,바비큐립-2", List.of(new OrderItem(Menu.ICE_CREAM, 3), new OrderItem(Menu.TAPAS, 2), new OrderItem(Menu.BBQ_RIBS, 2))),
                    Arguments.of("시저샐러드-7,해산물파스타-2,레드와인-3", List.of(new OrderItem(Menu.CAESAR_SALAD, 7), new OrderItem(Menu.SEAFOOD_PASTA, 2), new OrderItem(Menu.RED_WINE, 3)))
            );
        }

    }

    @Nested
    class getTotalOrderAmount {
        @ParameterizedTest
        @DisplayName("getTotalOrderAmount 메소드 테스트")
        @MethodSource("getTestData")
        void 총_주문_금액_합계를_잘_반환하는지_테스트(String orderInput, int totalOrderAmount) {
            Order order = Order.create(orderInput);
            assertThat(order.calculateTotalOrderAmount()).isEqualTo(totalOrderAmount);
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