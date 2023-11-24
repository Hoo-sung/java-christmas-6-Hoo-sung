package christmas.domain.util;

import christmas.domain.entity.Order;
import christmas.domain.entity.OrderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


class UtilTest {


    @Nested
    class CreateOrder {
        @ParameterizedTest
        @DisplayName("createOrderFromInput 메소드 테스트")
        @CsvSource(value = {
                "타파스-1,제로콜라-2,해산물파스타-7,양송이수프-10:타파스,제로콜라,해산물파스타,양송이수프",
                "레드와인-7,샴페인-9,제로콜라-11:레드와인,샴페인,제로콜라",
                "시저샐러드-7,바비큐립-8:시저샐러드,바비큐립"
        }, delimiter = ':')
        void 입력한_주문정보를_바탕으로_주문객체를_잘_반환하는지_테스트(String input, String menu) {
            String[] menuItems = menu.split(",");

            Order order = Order.create(input);
            List<String> actualMenu = order.getOrderItems().stream()
                    .map(OrderItem::getName)
                    .collect(Collectors.toList());

            assertThat(actualMenu).containsExactly(menuItems);
        }
    }

    @Nested
    class CreateFormattedAmount {
        @ParameterizedTest
        @DisplayName("createFormattedAmount 메소드 테스트")
        @CsvSource(value = {
                "60000: 60,000",
                "35000: 35,000",
                "8000:8,000",
                "654321:654,321",
                "7654321:7,654,321"
        }, delimiter = ':')
        void 형식에_맞추어_포매팅한_금액_출력하는지_테스트(int target, String expected) {
            assertThat(Util.createFormattedAmount(target)).isEqualTo(expected);
        }
    }


}