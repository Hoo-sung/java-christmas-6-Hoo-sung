package christmas.domain.event;

import christmas.domain.Menu;
public class FreeGift {

    private final Menu freeGift;
    private final int quantity;

    public FreeGift(Menu freeGift, int quantity) {
        this.freeGift = freeGift;
        this.quantity = quantity;
    }

    public int calculateBenefitPrice() {
        return freeGift.getPrice() * quantity;
    }

    public String getGiftName() {
        return freeGift.getName();
    }

    public int getQuantity() {
        return quantity;
    }

}
