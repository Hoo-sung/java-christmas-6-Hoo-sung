package christmas.util.Mapper;

import christmas.domain.EventBadge;
import christmas.dto.response.BadgeResponse;

public class BadgeResponseMapper {

    private static final String EMPTY = "없음";

    public static BadgeResponse of(EventBadge eventBadge) {
        return new BadgeResponse(eventBadge.getName());
    }

    public static BadgeResponse of() {
        return new BadgeResponse(EMPTY);
    }
}
