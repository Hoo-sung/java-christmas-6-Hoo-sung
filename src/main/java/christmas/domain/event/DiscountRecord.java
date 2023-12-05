package christmas.domain.event;

import christmas.domain.EventType;
import christmas.util.Formatting;

import java.util.EnumMap;
import java.util.Map;

import static christmas.system.Constant.ZERO;
import static christmas.system.IOMessage.*;

public class DiscountRecord {

    private final EnumMap<EventType, Integer> eachEventDiscountAmounts;

    public DiscountRecord(EnumMap<EventType, Integer> eachEventDiscountAmounts) {
        this.eachEventDiscountAmounts = eachEventDiscountAmounts;
    }

    public int getTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Integer discount : eachEventDiscountAmounts.values()) {
            totalDiscountAmount += discount;
        }
        return totalDiscountAmount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<EventType, Integer> entry : eachEventDiscountAmounts.entrySet()) {
            appendDiscountInfo(stringBuilder, entry.getKey().getEventName(), entry.getValue());
        }
        return stringBuilder.toString();
    }

    private void appendDiscountInfo(StringBuilder stringBuilder, String label, int amount) {
        if (amount != ZERO) {
            stringBuilder.append(label).append(MESSAGE_DELIMITER).append(Formatting.createFormattedAmount(amount)).append(MONEY_UNIT).append(System.lineSeparator());
        }
    }
}
