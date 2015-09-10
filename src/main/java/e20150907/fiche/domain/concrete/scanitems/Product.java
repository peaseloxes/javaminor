package e20150907.fiche.domain.concrete.scanitems;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class Product extends ScanItem{
    private double price;

    /**
     * Easy retrieval method for price.
     *
     * @return product price, including discounts etc.
     * @param amount
     */
    public double getPrice(final int amount){
        return getDiscount().getDiscountOn(price,amount);
    }

    @Override
    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append(getName());
        b.append(" @ ");
        b.append(StrUtil.twoDecimal(price));

        if(hasDiscount()){
            b.append("\n");
            b.append("Discount: ");
            b.append(getDiscount().toString());
            b.append(" New price: ");
            b.append(StrUtil.twoDecimal(getDiscount().getDiscountOn(getPrice(),1)));
            b.append("\n");
        }

        return b.toString();
    }
}
