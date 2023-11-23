package christmas.domain.entity;

public enum EventBadge {

    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");
    private static final int SANTA_THRESHOLD = 20000;
    private static final int TREE_THRESHOLD = 10000;
    private static final int STAR_THRESHOLD = 5000;

    private final String name;

    EventBadge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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
