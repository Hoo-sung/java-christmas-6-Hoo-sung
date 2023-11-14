package christmas.domain;

import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;


class DiscountRecordTest {

    private final DiscountManager discountManager = new DiscountManager();

    private final BonusEventManager bonusEventManager = new BonusEventManager();

    @Nested
    class GetDiscountRecordFields {

        @ParameterizedTest
        @DisplayName("혜택내역의 내용들 잘 반환되는지 메소드 테스트")
        @MethodSource("getTestData")
        void 혜택내역을_잘_반환하는지_테스트(Day day, Order order, int originalTotalAmount,
                               int expectedDDayDiscountAmount, int expectedWeekdayDiscountAmount, int expectedWeekendDiscountAmount, int expectedStarDayDiscountAmount,
                               int expectedBonusEventBenefit) {

            DiscountRecord discountRecord = DiscountRecord.create(day, order, originalTotalAmount, discountManager, bonusEventManager);
            assertAll(
                    () -> assertEquals(expectedDDayDiscountAmount, discountRecord.getdDayDiscountAmount()),
                    () -> assertEquals(expectedWeekdayDiscountAmount, discountRecord.getWeekdayDiscountAmount()),
                    () -> assertEquals(expectedWeekendDiscountAmount, discountRecord.getWeekendDiscountAmount()),
                    () -> assertEquals(expectedStarDayDiscountAmount, discountRecord.getStarDayDiscountAmount()),
                    () -> assertEquals(expectedBonusEventBenefit, discountRecord.getBonusEventBenefit())
            );
        }

        private static Stream<Arguments> getTestData() {
            return Stream.of(
                    Arguments.of(createDay(5),createOrderWithItems("샴페인", 25000, MenuType.BEVERAGE, 4), 100000,1400, 0, 0, 0, 0),
                    Arguments.of(createDay(7),createOrderWithItems("아이스크림", 5000, MenuType.DESSERT, 3), 15000, 1600, 6069, 0, 0, 0),
                    Arguments.of(createDay(25),createOrderWithItems("티본스테이크", 55000, MenuType.MAIN, 5), 275000, 3400, 0, 0, 1000, 25000)
            );
        }
        private static Day createDay(int day){
            return new Day(day);
        }
        private static Order createOrderWithItems(String name, int price, MenuType menuType, int quantity) {
            Order order = new Order();
            MenuItem menuItem = new MenuItem(name, price, menuType);
            OrderItem orderItem = new OrderItem(menuItem, quantity);
            order.addOrderItem(orderItem);
            return order;
        }
    }

}