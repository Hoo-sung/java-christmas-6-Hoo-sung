package christmas.domain.service;

import christmas.domain.EventBadge;

public final class EventBadgeGenerator {

    private static final int SANTA_THRESHOLD = 20000;
    private static final int TREE_THRESHOLD = 10000;
    private static final int STAR_THRESHOLD = 5000;

    public static EventBadge createBadge(int totalBenefitAmount){
        if(totalBenefitAmount >= SANTA_THRESHOLD)
            return EventBadge.SANTA;
        else if(totalBenefitAmount >=TREE_THRESHOLD)
            return EventBadge.TREE;
        else if(totalBenefitAmount >= STAR_THRESHOLD)
            return EventBadge.STAR;
        return null;
    }

}
