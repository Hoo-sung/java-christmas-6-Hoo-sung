package christmas.domain.manager.subclass;

import christmas.domain.BonusMenu;

import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;

public class MakeBonusEventDiscountTest {

    public int makeBonusEventBenefit(int originalTotalAmount) {
        if (originalTotalAmount < BONUS_MINIMUM_THRESHOLD)
            return ZERO;
        return BonusMenu.getTotalPriceForAllMenus();
    }
}
