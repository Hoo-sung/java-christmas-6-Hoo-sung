package christmas.domain.entity;

import christmas.domain.entity.subclass.BadgeCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventBadgeTest {

    @Nested
    class GetName {
        @Test
        @DisplayName("getName 메소드 테스트")
        void 이벤트_배지의_이름을_잘_반환되는지_테스트() {

            assertAll(
                    () -> assertEquals(EventBadge.NONE.getName(), "없음"),
                    () -> assertEquals(EventBadge.STAR.getName(), "별"),
                    () -> assertEquals(EventBadge.TREE.getName(), "트리"),
                    () -> assertEquals(EventBadge.SANTA.getName(), "산타")
            );
        }
    }

    @Nested
    class createBadge {
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
            BadgeCreator badgeCreator = new BadgeCreator();
            assertThat(badgeCreator.createBadge(totalBenefitAmount).getName()).isEqualTo(expected);
        }
    }

}