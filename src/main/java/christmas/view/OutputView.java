package christmas.view;

import christmas.domain.Day;

public final class OutputView {

    private static int MONTH = 12;

    private OutputView() {

    }
    public static void printResultStartMessage(int day){
        printMessage("12월 "+day+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        printEmptyLine();
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printEmptyLine() {
        System.out.println();
    }
}
