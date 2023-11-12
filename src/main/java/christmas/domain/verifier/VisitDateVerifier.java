package christmas.domain.verifier;

import christmas.system.ExceptionMessage;

import java.math.BigInteger;

public class VisitDateVerifier implements Verifier<String> {

    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);
    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE_MESSAGE);
        }
    }

    private void checkRange(String input) {
        BigInteger inputnum = new BigInteger(input);
        if (inputnum.compareTo(BigInteger.ONE) < 0 || inputnum.compareTo(BigInteger.valueOf(31)) > 0)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE_MESSAGE);
    }
}
