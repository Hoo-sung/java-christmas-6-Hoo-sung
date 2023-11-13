package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DayTest {

    @Nested
    class IsChristmasSeason {
        @ParameterizedTest
        @DisplayName("isChristmasSeason 메소드 테스트")
        @CsvSource(value = {"1:true", "7:true", "24:true", "25:true", "27:false","31:false"}, delimiter = ':')
        void 크리스마스_디데이_할인을_받는지_테스트(int input, boolean expected) {
            Day day = new Day(input);
            assertThat(day.isChristmasSeason()).isEqualTo(expected);
        }
    }

    @Nested
    class IsWeekday {
        @ParameterizedTest
        @DisplayName("isWeekday 메소드 테스트")
        @CsvSource(value = {"1:false", "7:true", "24:true", "25:true", "27:true","31:true"}, delimiter = ':')
        void 평일_할인을_받는지_테스트(int input, boolean expected) {
            Day day = new Day(input);
            assertThat(day.isWeekday()).isEqualTo(expected);
        }
    }

    @Nested
    class IsWeekend {
        @ParameterizedTest
        @DisplayName("isWeekend 메소드 테스트")
        @CsvSource(value = {"1:true", "7:false", "24:false", "25:false", "27:false","31:false"}, delimiter = ':')
        void 주말_할인을_받는지_테스트(int input, boolean expected) {
            Day day = new Day(input);
            assertThat(day.isWeekend()).isEqualTo(expected);
        }
    }

    @Nested
    class IsSpecialDay {
        @ParameterizedTest
        @DisplayName("isSpecialDay 메소드 테스트")
        @CsvSource(value = {"1:false", "7:false", "24:true", "25:true", "27:false","31:true"}, delimiter = ':')
        void 특별_할인을_받는지_테스트(int input, boolean expected) {
            Day day = new Day(input);
            assertThat(day.isSpecialDay()).isEqualTo(expected);
        }
    }

}