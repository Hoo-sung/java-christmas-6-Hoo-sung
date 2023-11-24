package christmas.domain.manager;

import christmas.domain.entity.Day;
import christmas.domain.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class DiscountManagerTest {

    private final DiscountManager discountManager = new DiscountManager();


    @ParameterizedTest
    @DisplayName("getDDayDiscount 메소드 테스트")
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "12, 2100",
            "25, 3400"
    })
    void 디데이_할인_금액_테스트(int input, int expected) {
        Day day = new Day(input);
        assertThat(discountManager.calculateDDayDiscount(day)).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("getWeekDayDiscount 메소드 테스트")
    @CsvSource(value = {
            "26:타파스-1,제로콜라-1:0",
            "3:티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:4046",
            "21:초코케이크-2,아이스크림-3:10115"
    }, delimiter = ':')
    void 평일_할인_금액_테스트(int dayInput, String orderInput, int expected) {
        Day day = new Day(dayInput);
        Order order = Order.create(orderInput);
        assertThat(discountManager.calculateWeekDayDiscount(day, order)).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("getWeekendDiscount 메소드 테스트")
    @CsvSource(value = {
            "26:타파스-1,제로콜라-1:0",
            "3:티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:0",
            "22:바비큐립-2,해산물파스타-1,샴페인-3:6069"
    }, delimiter = ':')
    void 주말_할인_금액_테스트(int dayInput, String orderInput, int expected) {
        Day day = new Day(dayInput);
        Order order = Order.create(orderInput);
        assertThat(discountManager.calculateWeekendDiscount(day, order)).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("getStarDayDiscount 메소드 테스트")
    @CsvSource(value = {
            "1:0",
            "3:1000",
            "25:1000",
            "26:0",
    }, delimiter = ':')
    void 특별_할인_금액_테스트(int dayInput, int expected) {
        Day day = new Day(dayInput);
        assertThat(discountManager.calculateSpecialDayDiscount(day)).isEqualTo(expected);
    }

}