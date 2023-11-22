package christmas.domain.verifier;

import java.math.BigInteger;

import static christmas.system.ExceptionMessage.*;

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
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    private void checkRange(String input) {
        BigInteger inputnum = new BigInteger(input);
        if (inputnum.compareTo(BigInteger.ONE) < 0 || inputnum.compareTo(BigInteger.valueOf(31)) > 0) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }
}
