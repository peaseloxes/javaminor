package e20150907.fiche.domain;

import e20150907.fiche.util.StringUtil;
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
    private PaymentType paymentType;
    private Map<Product, Integer> productsMap;

    public Bill(){
        productsMap = new HashMap<Product, Integer>();
    }

    public void addProduct(final Product product, final int amount){
        if(productsMap.containsKey(product)){
            productsMap.put(product, productsMap.get(product) + amount);
        }else{
            productsMap.put(product,amount);
        }
    }

    public void print(){
        double totalPrice = 0;
        double totalBasePrice = 0;

        logger.info("Payment type: " + paymentType);
        logger.info(" ");
        for (Map.Entry<Product, Integer> pair : productsMap.entrySet()){
            totalPrice += pair.getKey().getPrice() * pair.getValue();
            totalBasePrice += pair.getKey().getBasePrice() * pair.getValue();

            logger.info(pair.getKey().getName() + " x " + pair.getValue() + " @ " +
                    StringUtil.twoDecimal(pair.getKey().getBasePrice()) + " = " +
                    StringUtil.twoDecimal(pair.getKey().getBasePrice() * pair.getValue()));

            if(pair.getKey().hasDiscount()){
                logger.info("DISCOUNT: " + pair.getKey().getDiscountString());
                logger.info("NEW PRICE: " + pair.getValue() + " @ " +
                        StringUtil.twoDecimal(pair.getKey().getPrice()) + " = " +
                        StringUtil.twoDecimal(pair.getKey().getPrice() * pair.getValue()));
            }
            logger.info(" ");
        }
        logger.info("==============================");
        logger.info("Total Price: " + StringUtil.twoDecimal(totalPrice));
        logger.info("Total Discount: " + StringUtil.twoDecimal(totalBasePrice - totalPrice));
    }

}
