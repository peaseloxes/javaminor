package e20150907.fiche.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by alex on 9/7/15.
 */
public class StringUtil {
    public static String twoDecimal(final Number n){
        BigDecimal bd = new BigDecimal(n.doubleValue());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return String.valueOf(bd);
    }
}
