package christmas.domain.service.subclass;

import christmas.domain.entity.EventBadge;

public class BadgeCreator {

    private final int SANTA_THRESHOLD = 20000;
    private final int TREE_THRESHOLD = 10000;
    private final int STAR_THRESHOLD = 5000;

    public EventBadge createBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA_THRESHOLD)
            return EventBadge.SANTA;
        else if (totalBenefitAmount >= TREE_THRESHOLD)
            return EventBadge.TREE;
        else if (totalBenefitAmount >= STAR_THRESHOLD)
            return EventBadge.STAR;
        return EventBadge.NONE;
    }
}
