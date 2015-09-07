package e20150907.fiche.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/7/15.
 */
public abstract class Discount {
    protected static Logger log = LogManager.getLogger(Discount.class.getName());
    protected double discountValue;
    public Discount(double discount){
        this.discountValue = discount;
    }
    public abstract double getDiscountOn(final double price);

}
