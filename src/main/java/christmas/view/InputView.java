package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.Order;
import christmas.domain.util.Util;
import christmas.domain.verifier.OrderMenuVerifier;
import christmas.domain.verifier.Verifier;
import christmas.domain.verifier.VisitDateVerifier;

import static christmas.system.IOMessage.ORDER_PROMPT_MESSAGE;
import static christmas.system.IOMessage.VISIT_DATE_PROMPT_MESSAGE;

public final class InputView {

    private static final Verifier<String> visitDateVerifier = new VisitDateVerifier();
    private static final Verifier<String> orderMenuVerifier = new OrderMenuVerifier();


    private InputView() {

    }

    public static Day readDay() {
        while (true) {
            try {
                OutputView.printMessage(VISIT_DATE_PROMPT_MESSAGE);
                String input = Console.readLine();
                visitDateVerifier.check(input);
                return new Day(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    public static Order readOrder(){
        while(true){
            try{
                OutputView.printMessage(ORDER_PROMPT_MESSAGE);
                String input = Console.readLine();
                orderMenuVerifier.check(input);
                return Util.createOrderFromInput(input);
            }catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}

