package e20150907.fiche.domain.concrete.transactions;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.domain.abs.Transaction;
import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.util.PreferenceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 9/8/15.
 */
public class Sale extends Transaction{
    private static Logger logger = LogManager.getLogger(Sale.class.getName());

    // TODO clean up mess below

    // TODO make dynamic, properties file etc.
    private String categoryPricingName = "Type";
    private String[] pricingCategories = PreferenceUtil.getPricingCategories();

    private List<Double> totalPricesCategories;
    private List<Double> totalPricesCategoriesRemaining;

    public Sale(){
        super();
        totalPricesCategories = new ArrayList<>();
        totalPricesCategoriesRemaining = new ArrayList<>();
    }

    @Override
    public boolean handleCode(final String code){
        if(addItemToBasket(code)){
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }


    @Override
    public boolean handlePayment(final PaymentItem item) {

        if(item==null){
            return false;
        }

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

                        if(totalPricesCategories.get(i) > item.getAmount()){
                            setTotalPriceRemaining(getTotalPriceRemaining() - item.getAmount());
                        }else{
                            setTotalPriceRemaining(getTotalPriceRemaining() -totalPricesCategories.get(i));
                        }

                        logger.info("Paid " + item.getAmount() + " with a " + item.getType() + " coupon");
                        logger.info(totalPricesCategoriesRemaining.get(i) + " of " + item.getType() + " remaining");
                        logger.info(getTotalPriceRemaining() + " in total remaining");
                    }


                }
            }
        }else{
            // else total price
            if(item.getAmount()==-1){
                // paid everything
                logger.info("Paid " + getTotalPriceRemaining());
            }else{
                // paid partly or too much
                logger.info("Paid " + item.getAmount());
                setTotalPriceRemaining(getTotalPriceRemaining() - item.getAmount());
                logger.info(getTotalPriceRemaining() + " in total remaining");
            }

        }

        return true;
    }



    @Override
    public void closeTransaction(){
        calculate();
        logger.info("Total price: " + getTotalPrice());
        for (int i = 0; i < totalPricesCategories.size(); i++) {
            logger.info("Price " + pricingCategories[i] + ": " + totalPricesCategories.get(i));
        }
    }

    @Override
    public void calculate(){
        setTotalPrice(getBasket().calculateTotalPrice());
        setTotalPriceRemaining(getTotalPrice());
        for (String pricingCategory : pricingCategories) {
            double r = getBasket().calculatePriceForItemsWithProperty(categoryPricingName, pricingCategory);
            totalPricesCategories.add(r);
            totalPricesCategoriesRemaining.add(r);
        }
    }



    @Override
    public void finishTransaction(final boolean print){
        Bill bill = super.getBill();
        // TODO properties file
        bill.setDescription("Bill of Sale");
        bill.setScanItemsMap(getBasket().getScannedItems());
        bill.setTotalPrice(getTotalPrice());

        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < totalPricesCategories.size(); i++) {
            map.put(pricingCategories[i],totalPricesCategories.get(i));
        }
        bill.setTotalCategoryPrices(map);
        bill.setDiscount(getBasket().getEndDiscount());
        if(print){
            bill.print();
        }
    }
}
