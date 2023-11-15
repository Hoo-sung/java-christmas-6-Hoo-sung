package christmas.domain.entity;

import christmas.domain.util.Util;

import java.util.Arrays;

import static christmas.system.IOMessage.QUANTITY_UNIT;

public enum BonusMenu {
    CHAMPAGNE(Menu.CHAMPAGNE, 1);

    private final Menu menu;
    private final int quantity;

    BonusMenu(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static int getTotalPriceForAllMenus() {
        return Arrays.stream(BonusMenu.values())
                .mapToInt(BonusMenu::getTotalPrice)
                .sum();
    }

    public String getName() {
        return menu.getMenuName();
    }

    public int getTotalPrice() {
        return menu.getMenuPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getName() + " " + Util.createFormattedAmount(quantity) + QUANTITY_UNIT;
    }

    public static String getAllMenuDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<증정 메뉴>").append(System.lineSeparator());
        for (BonusMenu bonusMenu : BonusMenu.values()) {
            stringBuilder.append(bonusMenu.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
