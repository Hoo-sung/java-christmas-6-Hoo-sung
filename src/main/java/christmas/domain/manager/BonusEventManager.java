package christmas.domain.manager;

import christmas.domain.BonusMenu;

import java.util.Arrays;

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
        return Arrays.stream(BonusMenu.values())
                .mapToInt(bonusMenu -> bonusMenu.getPrice() * bonusMenu.getQuantity())
                .sum();
    }
}
