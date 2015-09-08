package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class Product {
    private String name;
    private ProductID identifier;
    private ProductPrice price;

    /**
     * If this product has an identifier that matches the parameter it will return this product, null otherwise.
     * @param id the id to search for
     * @return this object, or null if no identifier can be matched.
     */
    public Product hasId(final String id){
        if(identifier.hasId(id)){
            return this;
        }
        return null;
    }

    /**
     * Easy retrieval method for price.
     *
     * @return product price, including discounts etc.
     */
    public double getPrice(){
        return price.calculate();
    }

    public double getBasePrice(){
        return price.getBasePrice();
    }

    /**
     * Easy method for adding a customer specific discount.
     *
     * @param discount the discount in absolute value
     */
    public void addCustomDiscount(double discount){
        price.setDiscount(new DiscountFixedAmount(discount));
    }

    @Override
    public String toString(){
        return getName() + identifier + price;
    }

    /**
     * Easy retrieval method for discount checking.
     *
     * @return true if discount, false otherwise
     */
    public boolean hasDiscount(){
        return price.hasDiscount();
    }

    public String getDiscountString(){
        return price.toString();
    }
}
