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

    public static int calculateTotalPriceForAllMenus() {
        return Arrays.stream(BonusMenu.values())
                .mapToInt(BonusMenu::getTotalPrice)
                .sum();
    }

    public static String generateAllMenuDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<증정 메뉴>").append(System.lineSeparator());
        for (BonusMenu bonusMenu : BonusMenu.values()) {
            stringBuilder.append(bonusMenu.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getName() + " " + Util.createFormattedAmount(quantity) + QUANTITY_UNIT;
    }

    private String getName() {
        return menu.getMenuName();
    }

    private int getTotalPrice() {
        return menu.getMenuPrice() * quantity;
    }

}
