package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.Order;
import christmas.domain.verifier.OrderMenuVerifier;
import christmas.domain.verifier.Verifier;
import christmas.domain.verifier.VisitDateVerifier;

import static christmas.domain.util.Util.*;
import static christmas.view.OutputView.*;

public final class InputView {

    private static final Verifier<String> visitDateVerifier = new VisitDateVerifier();
    private static final Verifier<String> orderMenuVerifier = new OrderMenuVerifier();


    private InputView() {

    }

    public static Day readDay() {
        while (true) {
            try {
                String input = Console.readLine();
                visitDateVerifier.check(input);
                return new Day(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    public static Order readOrder() {
        while (true) {
            try {
                String input = Console.readLine();
                orderMenuVerifier.check(input);
                return createOrderFromInput(input);
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }
}

