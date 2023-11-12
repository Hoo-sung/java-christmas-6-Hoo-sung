package christmas.controller;

import christmas.domain.Day;
import christmas.domain.Order;
import christmas.domain.verifier.RuntimeVerifier;
import christmas.domain.verifier.Verifier;
import christmas.view.InputView;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

public class PlannerSystem {

    private final Day day;
    private final Order order;

    private final SettlementSystem settlementSystem;

    private final Verifier<Order> runtimeVerifier = new RuntimeVerifier();

    public PlannerSystem() {
        this.day = readDay();
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
        printResultStartMessage(day.getDay());
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
