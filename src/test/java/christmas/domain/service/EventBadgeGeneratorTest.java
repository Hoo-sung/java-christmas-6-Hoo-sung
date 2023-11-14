package christmas.domain.service;

import christmas.domain.service.subclass.CreateBadgeTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeGeneratorTest {

    @ParameterizedTest
    @DisplayName("createBadge 메소드 테스트")
    @CsvSource(value = {
            "100:없음",
            "3241:없음",
            "5312:별",
            "11123:트리",
            "23513:산타",
            "75432:산타"
    }, delimiter = ':')
    void 총_혜택_금액에_따른_이번트_배지_테스트(int totalBenefitAmount, String expected) {
        CreateBadgeTest createBadgeTest = new CreateBadgeTest();
        assertThat(createBadgeTest.createBadge(totalBenefitAmount).getName()).isEqualTo(expected);
    }


}