package christmas.domain;

import christmas.domain.manager.BonusEventManager;
import christmas.domain.manager.DiscountManager;
import christmas.domain.subclass.MockDiscountRecord;
import christmas.domain.util.Util;
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
        @DisplayName("혜택내역의 내용들 잘 반환하는지 메소드 테스트")
        @MethodSource("getTestData")
        void 혜택내역을_잘_반환하는지_테스트(Day day, Order order,
                               int expectedDDayDiscountAmount, int expectedWeekdayDiscountAmount, int expectedWeekendDiscountAmount, int expectedStarDayDiscountAmount,
                               int expectedBonusEventBenefit) {
            MockDiscountRecord mockDiscountRecord = MockDiscountRecord.create(day, order, discountManager, bonusEventManager);
            assertAll(
                    () -> assertEquals(expectedDDayDiscountAmount, mockDiscountRecord.getdDayDiscountAmount()),
                    () -> assertEquals(expectedWeekdayDiscountAmount, mockDiscountRecord.getWeekdayDiscountAmount()),
                    () -> assertEquals(expectedWeekendDiscountAmount, mockDiscountRecord.getWeekendDiscountAmount()),
                    () -> assertEquals(expectedStarDayDiscountAmount, mockDiscountRecord.getSpecialDayDiscountAmount()),
                    () -> assertEquals(expectedBonusEventBenefit, mockDiscountRecord.getBonusEventBenefit())
            );
        }

        private static Stream<Arguments> getTestData() {
            return Stream.of(
                    Arguments.of(createDay(3), createOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"), 1200, 4046, 0, 1000, 25000),
                    Arguments.of(createDay(26), createOrder("타파스-1,제로콜라-1"), 0, 0, 0, 0, 0),
                    Arguments.of(createDay(7), createOrder("양송이수프-2,바비큐립-1,아이스크림-2,초코케이크-1,제로콜라-1"), 1600, 6069, 0, 0, 0),
                    Arguments.of(createDay(25), createOrder("티본스테이크-2,시저샐러드-1,초코케이크-1,레드와인-2"), 3400, 2023, 0, 1000, 25000)
            );
        }
    }

    @Nested
    class GetTotalBenefitAmount {
        @ParameterizedTest
        @DisplayName("총 혜택금액을 잘 반환하는지 메소드 테스트")
        @MethodSource("getTestData")
        void 총혜택_금역을_잘_반환하는지_테스트(Day day, Order order, int expectedTotalBenefitAmount) {

            DiscountRecord discountRecord = DiscountRecord.create(day, order, discountManager, bonusEventManager);
            Assertions.assertThat(discountRecord.getTotalBenefitAmount()).isEqualTo(expectedTotalBenefitAmount);
        }

        private static Stream<Arguments> getTestData() {
            return Stream.of(
                    Arguments.of(createDay(3), createOrder("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"), 31246),
                    Arguments.of(createDay(26), createOrder("타파스-1,제로콜라-1"), 0),
                    Arguments.of(createDay(7), createOrder("양송이수프-2,바비큐립-1,아이스크림-2,초코케이크-1,제로콜라-1"), 7669),
                    Arguments.of(createDay(25), createOrder("티본스테이크-2,시저샐러드-1,초코케이크-1,레드와인-2"), 31423)
            );
        }

    }

    private static Day createDay(int day) {
        return new Day(day);
    }

    private static Order createOrder(String orderInput) {
        return Util.createOrderFromInput(orderInput);
    }

    ;


}