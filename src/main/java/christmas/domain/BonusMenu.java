package christmas.domain;

import christmas.domain.util.Util;

import java.util.Arrays;

import static christmas.system.IOMessage.QUANTITY_UNIT;

public enum BonusMenu {
    CHAMPAGNE(new BonusItem("샴페인", 25_000, 1));

    private final BonusItem bonusMenuItem;

    BonusMenu(BonusItem bonusMenuItem) {
        this.bonusMenuItem = bonusMenuItem;
    }

    public static int getTotalPriceForAllMenus() {
        return Arrays.stream(BonusMenu.values())
                .mapToInt(BonusMenu::getTotalPrice)
                .sum();
    }

    public String getName() {
        return bonusMenuItem.getName();
    }

    public int getTotalPrice() {
        return bonusMenuItem.getTotalPrice();
    }

    public int getQuantity() {
        return bonusMenuItem.getQuantity();
    }

    @Override
    public String toString() {
        return getName() + " " + Util.createFormattedAmount(getQuantity()) + QUANTITY_UNIT;
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
