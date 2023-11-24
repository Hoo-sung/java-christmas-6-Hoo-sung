package christmas.controller;

import christmas.domain.entity.Day;
import christmas.domain.entity.Order;
import christmas.view.InputView;
import java.util.function.Supplier;

import static christmas.domain.verifier.RuntimeVerifier.RUNTIME_VERIFIER;
import static christmas.system.IOMessage.ORDER_PROMPT_MESSAGE;
import static christmas.system.IOMessage.VISIT_DATE_PROMPT_MESSAGE;
import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

public class PlannerSystem {

    private final Day day;
    private final Order order;
    private final SettlementSystem settlementSystem;

    public PlannerSystem() {
        printMessage(VISIT_DATE_PROMPT_MESSAGE);
        this.day = readDay();
        printEventNotice();
        printMessage(ORDER_PROMPT_MESSAGE);
        this.order = readOrder(InputView::tryReadOrder);
        this.settlementSystem = new SettlementSystem(day, order);
    }
    public void run() {
        renderResult();
    }

    private Order readOrder(Supplier<Order> orderSupplier) {
        while (true) {
            try {
                Order order = orderSupplier.get();
                RUNTIME_VERIFIER.validate(order);
                return order;
            } catch (IllegalStateException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private void renderResult() {
        renderPlannerResult();
        settlementSystem.renderSettlementResult();

    }

    private void renderPlannerResult() {
        printResultStartMessage(day);
        printOrderList(order);
    }
}
