package christmas.domain.entity;

import static christmas.domain.entity.Menu.getMenuItemByName;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static OrderItem populateOrderItemFromInput(String input) {
        String[] orderItemSpec = input.split("-");
        String menu = orderItemSpec[0];
        int quantity = Integer.parseInt(orderItemSpec[1]);
        return new OrderItem(getMenuItemByName(menu), quantity);
    }

    public int calculateTotalItemAmount() {
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
