package christmas.domain;

public class PaymentCalculator {

    public int calculateOriginalTotal(Order order){
        int total =0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return total;
    }

}
