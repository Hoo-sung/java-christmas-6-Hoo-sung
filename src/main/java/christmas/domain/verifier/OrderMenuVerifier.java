package christmas.domain.verifier;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderMenuVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkMenuFormat(input);
    }

    private void checkMenuFormat(String input){
        String format = "[가-힣]+-\\d+";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }


}
