package christmas.domain.entity.subclass;

import christmas.domain.entity.Menu;

import java.util.Arrays;


public enum MockBonusMenu {

    ZERO_COLA(Menu.ZERO_COLA, 2),
    SEAFOOD_PASTA(Menu.SEAFOOD_PASTA, 1),
    CHRISTMAS_PASTA(Menu.CHRISTMAS_PASTA, 1);

    private final Menu menu;
    private final int quantity;

    MockBonusMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static int getTotalPriceForAllMenus() {
        return Arrays.stream(MockBonusMenu.values())
                .mapToInt(MockBonusMenu::getTotalPrice)
                .sum();
    }

    public String getName() {
        return menu.getMenuName();
    }

    public int getTotalPrice() {
        return menu.getMenuPrice() * quantity;
    }

}
