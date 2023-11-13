package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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


}