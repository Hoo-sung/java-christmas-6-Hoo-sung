package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.Order;
import christmas.domain.util.Util;

import static christmas.system.IOMessage.ORDER_PROMPT_MESSAGE;
import static christmas.system.IOMessage.VISIT_DATE_PROMPT_MESSAGE;

public final class InputView {
    private InputView() {

    }

    public static Day readDay() {
        while (true) {
            try {
                OutputView.printMessage(VISIT_DATE_PROMPT_MESSAGE);
                String input = Console.readLine();
                //검증 부분
                return new Day(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {

            }
        }
    }

    public static Order readOrder(){
        while(true){
            try{
                OutputView.printMessage(ORDER_PROMPT_MESSAGE);
                String input = Console.readLine();
                //검증 부분
                return Util.createOrderFromInput(input);
            }catch (IllegalArgumentException e) {

            }
        }
    }
}

