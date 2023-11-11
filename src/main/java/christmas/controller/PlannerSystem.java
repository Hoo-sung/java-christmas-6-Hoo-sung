package christmas.controller;

import christmas.domain.Day;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerSystem {

    private final Day day;
    private final Order order;

    private final SettlementSystem settlementSystem;

    public PlannerSystem() {
        this.day = InputView.readDay();
        this.order = InputView.readOrder();
        this.settlementSystem = new SettlementSystem(day,order);
    }

    public void run(){
        renderResult();
    }

    private void renderResult(){
        renderPlannerResult();
        settlementSystem.renderSettlementResult();

    }
    private void renderPlannerResult() {
        OutputView.printResultStartMessage(day.getDay());
        OutputView.printOrderList(order);
    }
}
