package christmas.domain.entity;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.entity.MenuType.*;

public enum Menu {

    MUSHROOM_SOUP("양송이수프", 6_000, APPETIZER),
    TAPAS("타파스", 5_500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, APPETIZER),

    T_BONE_STEAK("티본스테이크", 55_000, MAIN),
    BBQ_RIBS("바비큐립", 54_000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MAIN),

    CHOCOLATE_CAKE("초코케이크", 15_000, DESSERT),
    ICE_CREAM("아이스크림", 5_000, DESSERT),

    ZERO_COLA("제로콜라", 3_000, BEVERAGE),
    RED_WINE("레드와인", 60_000, BEVERAGE),
    CHAMPAGNE("샴페인", 25_000, BEVERAGE);

    private static final Map<String, Menu> MENU_MAP = new HashMap<>();
    private final String menuName;
    private final int price;
    private final MenuType menuType;

    Menu(String menuName, int price, MenuType menuType) {
        this.menuName = menuName;
        this.price = price;
        this.menuType = menuType;
    }

    static {
        for (Menu menu : Menu.values()) {
            MENU_MAP.put(menu.menuName, menu);
        }
    }

    public static Menu getMenuItemByName(String menuName) {
        return MENU_MAP.get(menuName);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

}
