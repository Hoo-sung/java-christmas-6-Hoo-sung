package christmas.domain.entity;

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

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

}
