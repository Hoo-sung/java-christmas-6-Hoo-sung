package christmas.domain.verifier;


import christmas.domain.Menu;
import christmas.domain.MenuItem;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderMenuVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkMenuFormat(input);
        checkMenuQuantity(input);
        checkDistinctMenu(input);
        checkMenuExistence(input);
    }

    private void checkMenuFormat(String input){
        String format = "[가-힣]+-\\d+";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMenuQuantity(String input){
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            check(orderInfo[1]);
            int quantity = Integer.parseInt(orderInfo[1]);
            if(quantity < 1)
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkDistinctMenu(String input){
        Set<String> uniqueMenuItems = new HashSet<>();
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            if(!uniqueMenuItems.add(orderInfo[0]))
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkMenuExistence(String input){
        String[] orders = input.split(",");
        for(String order : orders){
            String[] orderInfo = order.split("-");
            if(Menu.getMenuItemByName(orderInfo[0])== null)
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}
