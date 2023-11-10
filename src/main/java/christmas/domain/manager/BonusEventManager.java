package christmas.domain.manager;

import christmas.domain.BonusMenu;

public class BonusEventManager {

    private static final int BONUS_MINIMUM_THRESHOLD = 120000;
    public static int makeBonusEventDiscount(int originalTotalAmount){
        if(originalTotalAmount < BONUS_MINIMUM_THRESHOLD)
            return 0;
        return calculateTotalBonusMenuPrice();
    }

    private static int calculateTotalBonusMenuPrice(){
        int total = 0;
        for(BonusMenu bonusMenu : BonusMenu.values()){
            total += (bonusMenu.getPrice() * bonusMenu.getQuantity());
        }
        return total;
    }
}
