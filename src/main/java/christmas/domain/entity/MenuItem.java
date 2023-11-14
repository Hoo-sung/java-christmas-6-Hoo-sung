package christmas.domain.entity;

public class MenuItem {

    private final String name;
    private final int price;
    private final MenuType type;

    MenuItem(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }
}
