package christmas.domain.service;

import christmas.domain.Day;

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
    void 디데이_할인_금액을_테스트(int input, int expected) {
        Day day = new Day(input);
        assertThat(DiscountCalculator.calculateDDayDiscount(day)).isEqualTo(expected);
    }


}