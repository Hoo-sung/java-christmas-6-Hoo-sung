package christmas.controller;

import christmas.domain.Day;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerSystem {

    private Day day;
    private Order order;

    public void run(){
        initialize();
        renderPlannerResult();
        SettlementSystem settlementSystem = new SettlementSystem(day,order);
        settlementSystem.renderSettlementResult();
    }

    private void initialize(){
        day = InputView.readDay();
        order = InputView.readOrder();
    }
    private void renderPlannerResult() {
        OutputView.printResultStartMessage(day.getDay());
        OutputView.printOrderList(order);
    }
}
