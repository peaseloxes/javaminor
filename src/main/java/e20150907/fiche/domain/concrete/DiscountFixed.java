package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class DiscountFixed extends Discount {


    public DiscountFixed(double discount) {
        super(discount);
    }

    @Override
    public double getDiscountOn(final double price) {
        if(super.discountValue > price){
            log.info("Discount is larger than total price!");
        }
        return price - super.discountValue;
    }

    @Override
    public String toString(){
        return String.valueOf(super.discountValue) + " ";
    }
}
