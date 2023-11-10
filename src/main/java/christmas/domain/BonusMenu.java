package christmas.domain;

public enum BonusMenu {
    CHAMPAGNE(new MenuItem("샴페인", 25000, MenuType.BEVERAGE));

    private final MenuItem bonusMenuItem;

    BonusMenu(MenuItem bonusMenuItem) {
        this.bonusMenuItem = bonusMenuItem;
    }

    public MenuItem getBonusMenuItem() {
        return bonusMenuItem;
    }
}
