package christmas.domain.order;

import christmas.domain.Menu;
import christmas.domain.MenuType;

public class OrderItem {
    /**
     * OrderItem domain에서의 검증
     * 1. 존재하는 메뉴 타입인지
     * 2. 수량이 1~20개인지를 검증해야 한다.
     */

    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 20;
    private final Menu menu;
    private final int quantity;

    public OrderItem(String menuName, int quantity) {
        this.menu = validate(menuName, quantity);
        this.quantity = quantity;
    }

    private Menu validate(String menuName, int quantity) {
        Menu menu = validateExistMenu(menuName);
        validateQuantity(quantity);
        validateQuantity(quantity);
        return menu;
    }

    private Menu validateExistMenu(String menuName) {
        return Menu.findMenuItemByName(menuName).orElseThrow(IllegalArgumentException::new);
    }

    private void validateQuantity(int quantity) {
        if (isOutOfRange(quantity)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int quantity) {
        return quantity < MIN_COUNT || quantity > MAX_COUNT;
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
