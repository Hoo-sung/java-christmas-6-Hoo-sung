package christmas.util.Mapper;

import christmas.domain.event.FreeGift;
import christmas.dto.response.FreeGiftResponse;

public class FreeGiftResponseMapper {

    public static final String EMPTY = "없음";

    public static FreeGiftResponse of(FreeGift freeGift) {
        return new FreeGiftResponse(freeGift.getGiftName(), freeGift.calculateBenefitPrice(), freeGift.getQuantity());
    }

    public static FreeGiftResponse of() {
        return new FreeGiftResponse(EMPTY, 0, 0);
    }

}
