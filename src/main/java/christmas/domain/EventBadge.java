package christmas.domain;

public enum EventBadge {

    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    EventBadge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
