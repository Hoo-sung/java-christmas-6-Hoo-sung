package christmas.dto.request;

public class OrderItemRequest {
    private final String menuName;
    private final int quantity;

    public OrderItemRequest(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }
    public String getMenuName(){
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
