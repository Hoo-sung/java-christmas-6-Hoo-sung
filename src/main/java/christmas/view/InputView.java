package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.Order;

public final class InputView {

    private static final String VISIT_DATE_PROMPT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String ORDER_PROMPT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private InputView() {

    }

    public static Day readDay() {
        while (true) {
            try {
                System.out.println(VISIT_DATE_PROMPT_MESSAGE);
                String input = Console.readLine();
                //검증 부분
                return new Day(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {

            }
        }
    }
}

