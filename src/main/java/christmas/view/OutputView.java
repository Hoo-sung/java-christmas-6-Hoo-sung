package christmas.view;

import christmas.domain.Day;

public final class OutputView {

    private static int MONTH = 12;

    private OutputView() {

    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printEmptyLine() {
        System.out.println();
    }
}
