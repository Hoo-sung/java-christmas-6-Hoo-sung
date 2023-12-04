package christmas.domain;

import java.util.Optional;

public enum EventBadge {

    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int threshold;

    EventBadge(String name, int threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public static Optional<EventBadge> createBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA.threshold) {
            return Optional.of(SANTA);
        }
        if (totalBenefitAmount >= TREE.threshold) {
            return Optional.of(TREE);
        }
        if (totalBenefitAmount >= STAR.threshold) {
            return Optional.of(STAR);
        }
        return Optional.empty();
    }

    public String getName() {
        return name;
    }
}
