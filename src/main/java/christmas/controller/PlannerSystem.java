package christmas.controller;

import christmas.domain.Day;
import christmas.domain.Order;
import christmas.view.InputView;

public class PlannerSystem {

    private Day day;
    private Order order;

    public void run(){
        initialize();
        SettlementSystem settlementSystem = new SettlementSystem(day,order);
        settlementSystem.renderResult();
    }

    private void initialize(){
        day = InputView.readDay();
        order = InputView.readOrder();
    }
}
