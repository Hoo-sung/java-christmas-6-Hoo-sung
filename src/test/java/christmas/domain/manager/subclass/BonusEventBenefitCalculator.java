package christmas.domain.manager.subclass;

import christmas.domain.entity.BonusMenu;

import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;

public class BonusEventBenefitCalculator {

    public int makeBonusEventBenefit(int originalTotalAmount) {
        if (originalTotalAmount < BONUS_MINIMUM_THRESHOLD) {
            return ZERO;
        }
        return BonusMenu.calculateTotalPriceForAllMenus();
    }
}
