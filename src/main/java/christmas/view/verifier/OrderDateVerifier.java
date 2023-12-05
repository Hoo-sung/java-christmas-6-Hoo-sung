package christmas.view.verifier;

import static christmas.system.ExceptionMessage.INVALID_DATE_MESSAGE;

public class OrderDateVerifier implements Verifier<String> {

    public static final OrderDateVerifier ORDER_DATE_VERIFIER = new OrderDateVerifier();

    private OrderDateVerifier() {

    }
    /**
     * Integer가 아닌 경우
     * null이거나 공백인 경우 검증
     *
     * @param input
     */
    @Override
    public void validate(String input) {
        validateBlank(input);
        validateNumeric(input);
    }

    private void validateNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Verifier.throwIllegalArgumentError(INVALID_DATE_MESSAGE);
        }
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            Verifier.throwIllegalArgumentError(INVALID_DATE_MESSAGE);
        }
    }
}
