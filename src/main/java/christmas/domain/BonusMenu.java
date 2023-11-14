package christmas.domain;

import java.util.Arrays;

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
}
