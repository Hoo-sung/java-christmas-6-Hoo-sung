package christmas.domain.verifier;

import java.math.BigInteger;

public class VisitDateVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);
    }

    private void checkNumeric(String input){
        try{
            new BigInteger(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자가 아닙니다.");
        }
    }

    private void checkRange(String input){
        BigInteger inputnum = new BigInteger(input);
        if(inputnum.compareTo(BigInteger.ONE) < 0 || inputnum.compareTo(BigInteger.valueOf(31)) > 0)
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
