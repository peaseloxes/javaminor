package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.concrete.discounts.DiscountNone;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class ProductPrice {
    private double basePrice;
    private Discount discount;

    public ProductPrice(double basePrice){
        this.basePrice = basePrice;
    }

    public double calculate(){
        return discount.getDiscountOn(basePrice);
    }

    @Override
    public String toString(){
        String s = "Discount of ";
               s+= discount.toString();
        s+= " each";
        return s;
    }

    public boolean hasDiscount(){
        if(discount==null || discount instanceof DiscountNone){
            return false;
        }
        return true;
    }
}
