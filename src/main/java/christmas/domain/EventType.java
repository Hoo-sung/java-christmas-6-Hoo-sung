package christmas.domain;

import java.util.function.Function;

public enum EventType {

    CHRISTMAS("크리스마스 디데이 할인", orderDay -> {
        final int basicDiscountAmount = 1000;
        final int discountAmountUnit = 100;
        return (basicDiscountAmount + discountAmountUnit * (orderDay - 1));
    }),

    WEEKDAY("평일 할인", dessertCount -> {
        final int discountAmountUnit = 2023;
        return discountAmountUnit * dessertCount;
    }),

    WEEKEND("주말 할인", mainCourseCount -> {
        final int discountAmountUnit = 2023;
        return discountAmountUnit * mainCourseCount;
    }),
    SPECIAL("특별 할인", anything -> 1000);

    private final String eventName;
    private final Function<Integer, Integer> calculator;

    EventType(String eventName, Function<Integer, Integer> calculator) {
        this.eventName = eventName;
        this.calculator = calculator;
    }

    public int calculateDiscount(int calculateArgument){
        return calculator.apply(calculateArgument);
    }


}
