package christmas.domain;

public class OrderItem {

    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public int getTotalItemAmount() {
        return menuItem.getPrice() * quantity;
    }

    public MenuType getMenuType() {
        return menuItem.getType();
    }

    public String getName() {
        return menuItem.getName();
    }

    public int getQuantity() {
        return quantity;
    }
}
