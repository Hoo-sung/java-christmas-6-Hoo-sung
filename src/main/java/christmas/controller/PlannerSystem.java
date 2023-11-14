package christmas.controller;

import christmas.domain.entity.Day;
import christmas.domain.entity.Order;
import christmas.domain.verifier.RuntimeVerifier;
import christmas.domain.verifier.Verifier;
import christmas.view.InputView;

import static christmas.system.IOMessage.ORDER_PROMPT_MESSAGE;
import static christmas.system.IOMessage.VISIT_DATE_PROMPT_MESSAGE;
import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

public class PlannerSystem {

    private final Day day;
    private final Order order;

    private final SettlementSystem settlementSystem;

    private final Verifier<Order> runtimeVerifier = new RuntimeVerifier();

    public PlannerSystem() {
        printMessage(VISIT_DATE_PROMPT_MESSAGE);
        this.day = readDay();
        printEventNotice();
        printMessage(ORDER_PROMPT_MESSAGE);
        this.order = readOrder();
        this.settlementSystem = new SettlementSystem(day, order);
    }

    public void run() {
        renderResult();
    }

    private void renderResult() {
        renderPlannerResult();
        settlementSystem.renderSettlementResult();

    }

    private void renderPlannerResult() {
        printResultStartMessage(day);
        printOrderList(order);
    }

    private Order readOrder() {
        Order order;
        while (true) {
            try {
                order = InputView.readOrder();
                runtimeVerifier.check(order);
                return order;
            } catch (IllegalStateException e) {
                printMessage(e.getMessage());
            }
        }
    }
}
