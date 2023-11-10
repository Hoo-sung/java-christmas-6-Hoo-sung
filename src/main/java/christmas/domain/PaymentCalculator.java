package christmas.domain;

public class PaymentCalculator {

    public int calculateOriginalTotal(Order order){
        int total =0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return total;
    }

    public int calculateTotalDiscountAmount(DiscountRecord discountRecord){
        return discountRecord.getTotalDiscountAmount();
    }

    public int calculateTotalWithDiscount(int originalTotalAmount, DiscountRecord discountRecord){
        return originalTotalAmount - discountRecord.getTotalDiscountAmount();
    }
}
