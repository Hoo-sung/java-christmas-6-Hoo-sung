package christmas.domain.event;

import christmas.domain.EventType;
import christmas.domain.Menu;
import christmas.system.IOMessage;
import christmas.util.Formatting;

import static christmas.system.Constant.ZERO;
import static christmas.system.IOMessage.MESSAGE_DELIMITER;
import static christmas.system.IOMessage.MONEY_UNIT;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendDiscountInfo(stringBuilder, IOMessage.BONUS_EVENT, calculateBenefitPrice());
        return stringBuilder.toString();
    }

    private void appendDiscountInfo(StringBuilder stringBuilder, String label, int amount) {
        if (amount != ZERO) {
            stringBuilder.append(label).append(MESSAGE_DELIMITER).append(Formatting.createFormattedAmount(amount)).append(MONEY_UNIT).append(System.lineSeparator());
        }
    }
}
