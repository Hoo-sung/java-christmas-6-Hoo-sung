package christmas.domain;

public class PaymentCalculator {

    public int calculateOriginalTotal(Order order){
        int total =0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return total;
    }

    public int calculateTotalWithDiscount(int originalTotalAmount, DiscountRecord discountRecord){
        int minusValue = discountRecord.getdDayDiscountAmount() + discountRecord.getWeekdayDiscountAmount()
                + discountRecord.getWeekendDiscountAmount() + discountRecord.getStarDayDiscountAmount();
        return originalTotalAmount - minusValue;
    }
}
