package christmas.domain;

public enum BonusMenu {
    CHAMPAGNE(new BonusItem("샴페인", 25000, 1));

    private final BonusItem bonusMenuItem;

    BonusMenu(BonusItem bonusMenuItem) {
        this.bonusMenuItem = bonusMenuItem;
    }

    public BonusItem getBonusMenuItem() {
        return bonusMenuItem;
    }

    public String getName(){
        return bonusMenuItem.getName();
    }
    public int getPrice(){
        return bonusMenuItem.getPrice();
    }

    public int getQuantity(){
        return bonusMenuItem.getQuantity();
    }
}
