package e20150907.fiche.domain.concrete;

import e20150907.fiche.domain.abs.Discount;
import e20150907.fiche.domain.concrete.discounts.DiscountFixedAmount;
import e20150907.fiche.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

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
        double totalPrice = 0;
        double totalBasePrice = 0;

        logger.info("Payment type: " + paymentType);
        logger.info(" ");

        for (Map.Entry<Product, Integer> pair : productsMap.entrySet()){
            double basePrice = pair.getKey().getBasePrice();
            double endPrice = pair.getKey().getPrice();
            int amount = pair.getValue();
            totalPrice += endPrice * amount;
            totalBasePrice += basePrice * amount;

            logger.info(pair.getKey().getName() + " x " +amount + " @ "
                    + StrUtil.twoDecimal(basePrice) + " = "
                    + StrUtil.twoDecimal(basePrice * amount));

            if(pair.getKey().hasDiscount()){
                logger.info("DISCOUNT: " + pair.getKey().getDiscountString());
                logger.info("NEW PRICE: " + amount + " x " +
                        StrUtil.twoDecimal(endPrice) + " = " +
                        StrUtil.twoDecimal(endPrice * amount));
            }

            logger.info(" ");
        }
        logger.info("=========================================");
        logger.info("Subtotal: " + StrUtil.twoDecimal(totalBasePrice));
        logger.info("Total Item Discount: " + StrUtil.twoDecimal(totalBasePrice - totalPrice));
        logger.info("Subtotal: " + StrUtil.twoDecimal(totalPrice));
        if(discount!=null){
            totalPrice = discount.getDiscountOn(totalPrice);
            logger.info("Total End Discount: " + StrUtil.twoDecimal(discount.getDiscountValue()));
            logger.info("Subtotal: " + StrUtil.twoDecimal(totalPrice));
        }

        if(customer.getCard().getDiscount().getDiscountOn(totalPrice)!=0){
            logger.info("Customer Discount: " + customer.getCard().getDiscount().getDiscountValue() + "% over " + StrUtil.twoDecimal(totalPrice));
            totalPrice = customer.getCard().getDiscount().getDiscountOn(totalPrice);
        }
        logger.info("Total Price: " + StrUtil.twoDecimal(totalPrice));

        customer.getCard().addProductsToHistory(DateTime.now(), productsMap);
    }

}
