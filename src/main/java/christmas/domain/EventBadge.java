package christmas.domain;


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

    public static EventBadge createBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA.threshold) {
            return SANTA;
        }
        if (totalBenefitAmount >= TREE.threshold) {
            return TREE;
        }
        if (totalBenefitAmount >= STAR.threshold) {
            return STAR;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
