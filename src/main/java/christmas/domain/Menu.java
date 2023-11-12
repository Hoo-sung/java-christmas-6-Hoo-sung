package christmas.domain;

public enum Menu {

    MUSHROOM_SOUP(new MenuItem("양송이수프", 6000, MenuType.APPETIZER)),
    TAPAS(new MenuItem("타파스", 5500, MenuType.APPETIZER)),
    CAESAR_SALAD(new MenuItem("시저샐러드", 8000, MenuType.APPETIZER)),

    T_BONE_STEAK(new MenuItem("티본스테이크", 55000, MenuType.MAIN)),
    BBQ_RIBS(new MenuItem("바비큐립", 54000, MenuType.MAIN)),
    SEAFOOD_PASTA(new MenuItem("해산물파스타", 35000, MenuType.MAIN)),
    CHRISTMAS_PASTA(new MenuItem("크리스마스파스타", 25000, MenuType.MAIN)),

    CHOCOLATE_CAKE(new MenuItem("초코케이크", 15000, MenuType.DESSERT)),
    ICE_CREAM(new MenuItem("아이스크림", 5000, MenuType.DESSERT)),


    ZERO_COLA(new MenuItem("제로콜라", 3000, MenuType.BEVERAGE)),
    RED_WINE(new MenuItem("레드와인", 60000, MenuType.BEVERAGE)),
    CHAMPAGNE(new MenuItem("샴페인", 25000, MenuType.BEVERAGE));

    private final MenuItem menuItem;

    Menu(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public static MenuItem getMenuItemByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getMenuItem().getName().equals(menuName)) {
                return menu.getMenuItem();
            }
        }
        return null;
    }
}
