package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

}