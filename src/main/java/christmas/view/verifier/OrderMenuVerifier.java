package christmas.view.verifier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class OrderMenuVerifier implements Verifier<String>{
    public static final OrderMenuVerifier ORDER_MENU_VERIFIER = new OrderMenuVerifier();

    private final Pattern pattern;

    private OrderMenuVerifier() {
        this.pattern = Pattern.compile("[가-힣]+-\\d+(,[가-힣]+-\\d+)*");
    }
    @Override
    public void validate(final String input) {
        validateMenuFormat(input);
    }
    private void validateMenuFormat(final String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderFormat(order);
        }
    }
    private void validateOrderFormat(final String order) {
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            Verifier.throwIllegalArgumentError(INVALID_ORDER_MESSAGE);
        }
    }


}
