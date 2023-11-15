package christmas.domain.manager;

import christmas.domain.entity.BonusMenu;
import christmas.domain.entity.Order;


import static christmas.system.Constant.BONUS_MINIMUM_THRESHOLD;
import static christmas.system.Constant.ZERO;

public class BonusEventManager {

    public BonusEventManager() {
    }
    public int makeBonusEventBenefit(Order order) {
        int originalTotalAmount = order.calculateTotalOrderAmount();
        if (originalTotalAmount < BONUS_MINIMUM_THRESHOLD)
            return ZERO;
        return BonusMenu.calculateTotalPriceForAllMenus();
    }
}
