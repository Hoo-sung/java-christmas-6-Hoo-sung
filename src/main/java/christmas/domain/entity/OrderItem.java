package christmas.domain.entity;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int getTotalItemAmount() {
        return menu.getMenuPrice() * quantity;
    }

    public MenuType getMenuType() {
        return menu.getMenuType();
    }

    public String getName() {
        return menu.getMenuName();
    }

    public int getQuantity() {
        return quantity;
    }
}
