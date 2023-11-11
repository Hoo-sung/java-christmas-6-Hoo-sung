package christmas.domain.verifier;

import java.math.BigInteger;

public class VisitDateVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
    }

    private void checkNumeric(String input){
        try{
            new BigInteger(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자가 아닙니다.");
        }
    }
}
