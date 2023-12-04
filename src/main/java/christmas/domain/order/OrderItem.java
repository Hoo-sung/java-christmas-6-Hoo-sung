package christmas.domain.order;

import christmas.domain.Menu;
import christmas.domain.MenuType;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public boolean isSameMenuType(MenuType menuType) {
        return menu.getMenuType() == menuType;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getPrice() {
        return menu.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int calculateTotalItemAmount() {
        return menu.getPrice() * quantity;
    }

}
