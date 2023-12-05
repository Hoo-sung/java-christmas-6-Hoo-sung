package christmas.util;

import java.text.DecimalFormat;

public final class Formatting {

    public static String createFormattedAmount(int target) {
        DecimalFormat formatter = new DecimalFormat("###,##0");
        return formatter.format(target);
    }
}
