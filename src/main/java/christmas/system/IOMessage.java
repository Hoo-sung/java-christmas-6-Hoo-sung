package christmas.system;

public final class IOMessage {
    private IOMessage(){

    }

    public static final String VISIT_DATE_PROMPT_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static final String ORDER_PROMPT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static final String NONE = "없음";

    public static final String QUANTITY_UNIT = "개";

    public static final String MONEY_UNIT = "원";
}
