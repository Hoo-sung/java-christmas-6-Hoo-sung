package christmas.domain.verifier.subclass;

import java.math.BigInteger;

import static christmas.system.ExceptionMessage.INVALID_DATE_MESSAGE;

public class MockVisitDateVerifier {

    public void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
        }
    }

    public void checkRange(String input) {
        BigInteger inputnum = new BigInteger(input);
        if (inputnum.compareTo(BigInteger.ONE) < 0 || inputnum.compareTo(BigInteger.valueOf(31)) > 0)
            throw new IllegalArgumentException(INVALID_DATE_MESSAGE);
    }
}
