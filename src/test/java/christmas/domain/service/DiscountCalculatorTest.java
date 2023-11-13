package christmas.domain.service;

import christmas.domain.Day;

import christmas.domain.Order;
import christmas.domain.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;


class DiscountCalculatorTest {

    @ParameterizedTest
    @DisplayName("calculateDDayDiscount 메소드 테스트")
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "12, 2100",
            "25, 3400"
    })
    void 디데이_할인_금액_테스트(int input, int expected) {
        Day day = new Day(input);
        assertThat(DiscountCalculator.calculateDDayDiscount(day)).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("calculateWeekDayDiscount 메소드 테스트")
    @CsvSource(value = {
            "타파스-1,제로콜라-2,해산물파스타-7,양송이수프-4:0",
            "타파스-1,제로콜라-1:0",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:4046",
            "초코케이크-2,아이스크림-3:10115"
    },delimiter = ':')
    void 평일_할인_금액_테스트(String input, int expected) {
        Order order = Util.createOrderFromInput(input);
        assertThat(DiscountCalculator.calculateWeekDayDiscount(order)).isEqualTo(expected);
    }


}