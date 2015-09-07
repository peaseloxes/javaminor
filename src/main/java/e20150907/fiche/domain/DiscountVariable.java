package e20150907.fiche.domain;

import e20150907.fiche.util.StringUtil;

/**
 * Created by alex on 9/7/15.
 */
public class DiscountVariable extends Discount{

    public DiscountVariable(final long discount) {
        super(discount);
        if(discount > 100){
            log.info("Discount is more than 100%!");
        }
    }

    @Override
    public double getDiscountOn(final double price) {
        return price * ((100-discountValue)/100);
    }

    @Override
    public String toString(){
        return StringUtil.twoDecimal(super.discountValue) + "% ";
    }
}
