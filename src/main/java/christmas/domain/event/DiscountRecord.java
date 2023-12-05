package christmas.domain.event;

import christmas.domain.EventType;

import java.util.EnumMap;


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

    public boolean isExistSpecificEventDiscount(EventType eventType) {
        return getDiscountAmount(eventType) != 0;
    }
    public int getDiscountAmount(EventType eventType){
        if (eachEventDiscountAmounts.containsKey(eventType)) {
            return eachEventDiscountAmounts.get(eventType);
        }
        return 0;
    }

}
