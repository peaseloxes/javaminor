package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class ProductPrice {
    private double basePrice;
    private List<Discount> discounts;

    public ProductPrice(double basePrice){
        this.basePrice = basePrice;
        discounts = new ArrayList<Discount>();
    }

    public double calculate(){
        double discountPrice = basePrice;
        for(Discount discount : discounts){
            discountPrice = discount.getDiscountOn(discountPrice);
        }
        return discountPrice;
    }

    public ProductPrice addDiscounts(final Discount... discount){
        Collections.addAll(discounts, discount);
        return this;
    }
    @Override
    public String toString(){
        String s = StrUtil.twoDecimal(basePrice) + ", discount(s): ";
        for (Discount discount : discounts) {
            s+= discount.toString();
        }
        return s;
    }

    public boolean hasDiscount(){
        if(discounts.size() > 0){
            return true;
        }
        return false;
    }
}
