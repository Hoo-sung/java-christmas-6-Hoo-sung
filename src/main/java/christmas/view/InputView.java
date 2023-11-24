package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.entity.Day;
import christmas.domain.entity.Order;

import static christmas.domain.verifier.OrderMenuVerifier.ORDER_MENU_VERIFIER;
import static christmas.domain.verifier.VisitDateVerifier.VISIT_DATE_VERIFIER;
import static christmas.view.OutputView.*;

public final class InputView {

    private InputView() {

    }

    public static Day readDay() {
        while (true) {
            try {
                String input = Console.readLine();
                VISIT_DATE_VERIFIER.validate(input);
                return new Day(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    public static Order tryReadOrder() {
        while (true) {
            try {
                String input = Console.readLine();
                ORDER_MENU_VERIFIER.validate(input);
                return Order.create(input);
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }
}

