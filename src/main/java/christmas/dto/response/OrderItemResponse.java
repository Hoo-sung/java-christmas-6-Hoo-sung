package christmas.dto.response;

public class OrderItemResponse {

    private final String menuName;

    private final int quantity;

    private final int price;

    public OrderItemResponse(String menuName, int quantity, int price) {
        this.menuName = menuName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
    public int getTotalPrice(){
        return quantity * price;
    }
}
