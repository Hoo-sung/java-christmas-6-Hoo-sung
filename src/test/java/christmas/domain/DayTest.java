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
        void 크리스마스_디데이_할인을_받는지_테스트(int dayNum, boolean expected) {
            Day day = new Day(dayNum);
            assertThat(day.isChristmasSeason()).isEqualTo(expected);
        }
    }

}