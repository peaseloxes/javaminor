package e20150907.fiche.domain.concrete.scanitems;

import e20150907.fiche.domain.abs.ScanItem;
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
        b.append(" ");
        b.append(price);
        b.append("\n");
        if(hasDiscount()){
            b.append("Discount: ");
            b.append(getDiscount().toString());
            b.append(" ");
            b.append(getPrice());
            b.append("\n");
        }

        return b.toString();
    }
}
