package christmas.service.badge;

import christmas.domain.EventBadge;

import java.util.Optional;

public class BadgeService {

    public Optional<EventBadge> applyBadge(final int totalBenefitAmount){
        return EventBadge.createBadge(totalBenefitAmount);
    }
}
