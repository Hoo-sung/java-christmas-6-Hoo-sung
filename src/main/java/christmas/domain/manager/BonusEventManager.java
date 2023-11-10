package christmas.domain.manager;

import christmas.domain.Menu;

public class BonusEventManager {

    private static final int BONUS_MINIMUM_THRESHOLD = 120000;
    public static int makeBonusEventDiscount(int originalTotalAmount){
        if(originalTotalAmount < BONUS_MINIMUM_THRESHOLD)
            return 0;
        return Menu.CHAMPAGNE.getMenuItem().getPrice();
    }
}
