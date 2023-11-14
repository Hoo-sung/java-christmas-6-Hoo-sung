package christmas.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static christmas.domain.MenuType.*;

public enum Menu {

    MUSHROOM_SOUP(new MenuItem("양송이수프", 6_000, APPETIZER)),
    TAPAS(new MenuItem("타파스", 5_500, APPETIZER)),
    CAESAR_SALAD(new MenuItem("시저샐러드", 8_000, APPETIZER)),

    T_BONE_STEAK(new MenuItem("티본스테이크", 55_000, MAIN)),
    BBQ_RIBS(new MenuItem("바비큐립", 54_000, MAIN)),
    SEAFOOD_PASTA(new MenuItem("해산물파스타", 35_000, MAIN)),
    CHRISTMAS_PASTA(new MenuItem("크리스마스파스타", 25_000, MAIN)),

    CHOCOLATE_CAKE(new MenuItem("초코케이크", 15_000, DESSERT)),
    ICE_CREAM(new MenuItem("아이스크림", 5_000, DESSERT)),


    ZERO_COLA(new MenuItem("제로콜라", 3_000, BEVERAGE)),
    RED_WINE(new MenuItem("레드와인", 60_000, BEVERAGE)),
    CHAMPAGNE(new MenuItem("샴페인", 25_000, BEVERAGE));

    private static final Map<String, Menu> MENU_MAP = new HashMap<>();
    private final MenuItem menuItem;

    Menu(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    static {
        for (Menu menu : Menu.values()) {
            MENU_MAP.put(menu.getMenuItem().getName(), menu);
        }
    }

    public static Optional<MenuItem> getMenuItemByName(String menuName) {
        return Optional.ofNullable(MENU_MAP.get(menuName))
                .map(Menu::getMenuItem);
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

}
