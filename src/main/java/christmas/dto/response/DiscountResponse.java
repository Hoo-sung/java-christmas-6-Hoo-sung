package christmas.dto.response;

import java.util.Map;

public class DiscountResponse {

    private final Map<String, Integer> eventNameAndDiscounts;

    public DiscountResponse(Map<String, Integer> eventNameAndDiscounts) {
        this.eventNameAndDiscounts = eventNameAndDiscounts;
    }

    public Map<String, Integer> getEventNameAndDiscount() {
        return eventNameAndDiscounts;
    }
    public boolean isEmpty() {
        return eventNameAndDiscounts == null || eventNameAndDiscounts.isEmpty();
    }

    public int getTotalDiscountAmount() {
        int sum = 0;
        for (int discountAmount : eventNameAndDiscounts.values()) {
            sum += discountAmount;
        }
        return sum;
    }


}
