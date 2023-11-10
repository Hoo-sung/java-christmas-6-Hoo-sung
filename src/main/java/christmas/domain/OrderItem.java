package christmas.domain;

public class OrderItem {

    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuType getMenuType(){
        return menuItem.getType();
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public String getName(){ return menuItem.getName(); }
    public int getPrice(){
        return menuItem.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }
}
