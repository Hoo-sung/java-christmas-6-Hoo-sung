package christmas.dto.response;


public class FreeGiftResponse {

    private static final String EMPTY = "없음";
    private final String name;

    private final int benefitPrice;

    private final int quantity;

    public FreeGiftResponse(String name, int benefitPrice, int quantity) {
        this.name = name;
        this.benefitPrice = benefitPrice;
        this.quantity = quantity;
    }

    public boolean isEmpty() {
        return name == null || name.equals(EMPTY);
    }
    public String getName() {
        return name;
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

}
