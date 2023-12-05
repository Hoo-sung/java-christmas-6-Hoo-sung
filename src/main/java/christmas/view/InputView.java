package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.view.verifier.OrderDateVerifier.ORDER_DATE_VERIFIER;
import static christmas.view.verifier.OrderMenuVerifier.ORDER_MENU_VERIFIER;

public class InputView {

    private static final String DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int readDate(){
        System.out.println(DATE_MESSAGE);
        String dateInput = Console.readLine();
        ORDER_DATE_VERIFIER.validate(dateInput);
        return Integer.parseInt(dateInput);
    }

    public String readMenuForm(){
        System.out.println(MENU_MESSAGE);
        String menuForm = Console.readLine();
        ORDER_MENU_VERIFIER.validate(menuForm);
        return menuForm;
    }
}
