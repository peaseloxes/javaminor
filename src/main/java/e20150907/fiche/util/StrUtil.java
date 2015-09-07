package e20150907.fiche.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by alex on 9/7/15.
 */
public class StrUtil {

    /**
     * Converts a number to a String with two decimals.
     *
     * @param n the number to convert.
     * @return a two decimal numeric string
     */
    public static String twoDecimal(final Number n){
        BigDecimal d = new BigDecimal(n.doubleValue());
        d = d.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(d);
    }
}
