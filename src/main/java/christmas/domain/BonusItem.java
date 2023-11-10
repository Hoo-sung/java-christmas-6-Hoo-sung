package christmas.domain;

public class BonusItem {
    private final String name;
    private final int price;
    private final int quantity;

    BonusItem(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
