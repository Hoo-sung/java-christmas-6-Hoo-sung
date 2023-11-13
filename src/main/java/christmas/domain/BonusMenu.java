package christmas.domain;

public enum BonusMenu {
    CHAMPAGNE(new BonusItem("샴페인", 25_000, 1));

    private final BonusItem bonusMenuItem;

    BonusMenu(BonusItem bonusMenuItem) {
        this.bonusMenuItem = bonusMenuItem;
    }

    public static int getTotalPriceForAllMenus() {
        int total = 0;
        for (BonusMenu menu : BonusMenu.values()) {
            total += menu.getTotalPrice();
        }
        return total;
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
