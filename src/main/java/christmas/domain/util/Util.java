package christmas.domain.util;


import java.text.DecimalFormat;

public final class Util {
    public static String createFormattedAmount(int target) {
        DecimalFormat formatter = new DecimalFormat("###,##0");
        return formatter.format(target);
    }

}
