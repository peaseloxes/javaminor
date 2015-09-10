package e20150907.fiche.logic;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.util.PreferenceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/8/15.
 */
public class Sale {
    private static Logger logger = LogManager.getLogger(Sale.class.getName());
    private Basket basket;
    private Bill bill;
    private ScanItemRepository repository;

    private double totalPrice;
    private double totalRemaining;

    // TODO make dynamic, properties file etc.
    private String categoryPricingName = "Type";
    private String[] pricingCategories = PreferenceUtil.getPricingCategories();

    private List<Double> totalPricesCategories;
    private List<Double> totalPricesCategoriesRemaining;



    public Sale(){
        repository = new ScanItemRepository();
        bill = new Bill();
        basket = new Basket();
        totalPrice = 0;
        totalRemaining = 0;
        totalPricesCategories = new ArrayList<Double>();
        totalPricesCategoriesRemaining = new ArrayList<Double>();
    }

    public boolean handleCode(final String code){
        ScanItem item = repository.getItemByCode(code);
        if(item != null){
            basket.addToBasket(item);
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }

    public void finish(){
        calculateBasketContents();
        //bill.print();
        logger.info("Total price: " + totalPrice);
        for (int i = 0; i < totalPricesCategories.size(); i++) {
            logger.info("Price " + pricingCategories[i] + ": " + totalPricesCategories.get(i));
        }
    }

    private void calculateBasketContents(){
        totalPrice = basket.calculateTotalPrice();
        totalRemaining += totalPrice;
        for (String pricingCategory : pricingCategories) {
            double r = basket.calculatePriceForItemsWithProperty(categoryPricingName, pricingCategory);
            totalPricesCategories.add(r);
            totalPricesCategoriesRemaining.add(r);
        }
    }

    public void handlePayment(final PaymentItem item) {

        // if item has a type requirement
        if (item.hasType()){

            // loop through all known types and associated prices
            for (int i = 0; i < totalPricesCategories.size(); i++) {

                // if one of the type matches type of payment item
                if(pricingCategories[i].equals(item.getType())){
                    // and the amount is above 0
                    if(totalPricesCategories.get(i)>0){
                        double remainder = item.remainder(totalPricesCategories.get(i));
                        totalPricesCategoriesRemaining.add(i, remainder);

                        // TODO not quite right yet
                        if(totalPricesCategories.get(i) > item.getAmount()){
                            totalRemaining -= item.getAmount();
                        }else{
                            totalRemaining -= (totalPricesCategories.get(i));
                        }

                        logger.info("Paid " + item.getAmount() + " with a " + item.getType() + " coupon");
                        logger.info(totalPricesCategoriesRemaining.get(i) + " of " + item.getType() + " remaining");
                        logger.info(totalRemaining + " in total remaining");
                    }


                }
            }
        }else{
            // else total price
            totalRemaining -= item.remainder(totalPrice);
        }

    }

//    public void handlePayment(final PaymentItem item){
//
//        // if it's an item with a type
//        if (item.hasType()){
//
//        }
//
//        // else, handle as amount
//        totalRemaining = totalRemaining - item.getAmount();
//    }
}
