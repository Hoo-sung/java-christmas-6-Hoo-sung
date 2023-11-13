package christmas.domain.verifier.subclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static christmas.system.ExceptionMessage.INVALID_ORDER_MESSAGE;

public class CheckMenuFormatTest {

    private final Pattern pattern;

    public CheckMenuFormatTest() {
        this.pattern = Pattern.compile("[가-힣]+-\\d+(,[가-힣]+-\\d+)*");
    }

    public void checkMenuFormat(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            validateOrderFormat(order);
        }
    }

    private void validateOrderFormat(String order) {
        Matcher matcher = pattern.matcher(order);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }
}