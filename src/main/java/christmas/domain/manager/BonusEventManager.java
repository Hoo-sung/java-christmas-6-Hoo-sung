package christmas.domain.manager;

import christmas.domain.BonusMenu;

import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;

public class BonusEventManager {

    public BonusEventManager() {
    }

    public int makeBonusEventDiscount(int originalTotalAmount) {
        if (originalTotalAmount < BONUS_MINIMUM_THRESHOLD)
            return ZERO;
        return calculateTotalBonusMenuPrice();
    }

    private int calculateTotalBonusMenuPrice() {
        int total = ZERO;
        for (BonusMenu bonusMenu : BonusMenu.values()) {
            total += (bonusMenu.getPrice() * bonusMenu.getQuantity());
        }
        return total;
    }
}
