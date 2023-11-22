package christmas.domain.service;

import christmas.domain.entity.DiscountRecord;
import christmas.domain.entity.EventBadge;

public final class EventBadgeGenerator {

    private static final int SANTA_THRESHOLD = 20000;
    private static final int TREE_THRESHOLD = 10000;
    private static final int STAR_THRESHOLD = 5000;

    public static EventBadge createBadge(DiscountRecord discountRecord) {
        int totalBenefitAmount = discountRecord.calculateTotalBenefitAmount();
        if (totalBenefitAmount >= SANTA_THRESHOLD) {
            return EventBadge.SANTA;
        }
        if (totalBenefitAmount >= TREE_THRESHOLD) {
            return EventBadge.TREE;
        }
        if (totalBenefitAmount >= STAR_THRESHOLD) {
            return EventBadge.STAR;
        }
        return EventBadge.NONE;
    }

}
