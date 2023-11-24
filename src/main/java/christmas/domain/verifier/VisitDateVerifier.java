package christmas.domain.verifier;

import static christmas.system.Constant.FIRST_DAY_OF_MONTH;
import static christmas.system.Constant.LAST_DAY_OF_MONTH;
import static christmas.system.ExceptionMessage.*;

public class VisitDateVerifier implements Verifier<String> {

    public static final VisitDateVerifier VISIT_DATE_VERIFIER = new VisitDateVerifier();

    private VisitDateVerifier() {

    }

    @Override
    public void validate(final String input) {
        validateNumeric(input);
    }

    public void validateInputInDomain(final int input) {
        validateRange(input);
    }


    private void validateNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Verifier.throwIllegalArgumentError(INVALID_DATE_MESSAGE);
        }
    }

    private void validateRange(final int input) {
        if (input < FIRST_DAY_OF_MONTH || input > LAST_DAY_OF_MONTH) {
            Verifier.throwIllegalArgumentError(INVALID_DATE_MESSAGE);
        }
    }
}
