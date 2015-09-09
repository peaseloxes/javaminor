package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.domain.concrete.scanitems.Customer;
import e20150907.fiche.domain.concrete.scanitems.Product;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/7/15.
 */
@Getter
@Setter
public class Bill {
    private Logger logger = LogManager.getLogger(Bill.class.getName());
    private Map<Product, Integer> productsMap;

    private Customer customer;
    private Discount discount = new DiscountFixedAmount(100);

    public Bill(){
        productsMap = new HashMap<Product, Integer>();
    }

    /**
     * Add a product to be billed.
     *
     * @param product the product to add
     * @param amount the amount purchased
     */
    public void addProduct(final Product product, final int amount){
        if(productsMap.containsKey(product)){
            productsMap.put(product, productsMap.get(product) + amount);
        }else{
            productsMap.put(product,amount);
        }
    }

    /**
     * Print the bill to the logger.
     */
    public void print(){

        // TODO fix horror below


    }

}
