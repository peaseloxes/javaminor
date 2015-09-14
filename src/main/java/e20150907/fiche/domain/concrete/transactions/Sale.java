package e20150907.fiche.domain.concrete.transactions;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.abs.Transaction;
import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
import e20150907.fiche.logic.ScanItemRepository;
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

    @Override
    public boolean handleCode(final String code){
        ScanItem item = repository.getItemByCode(code);
        if(item != null){
            basket.addToBasket(item);
            return true;
        }
        logger.error("The code:    " + code + "    can not be recognized.");
        return false;
    }

    @Override
    public void closeTransaction(){
        calculate();
        logger.info("Total price: " + totalPrice);
        for (int i = 0; i < totalPricesCategories.size(); i++) {
            logger.info("Price " + pricingCategories[i] + ": " + totalPricesCategories.get(i));
        }
    }

    @Override
    public void calculate(){
        totalPrice = basket.calculateTotalPrice();
        totalRemaining += totalPrice;
        for (String pricingCategory : pricingCategories) {
            double r = basket.calculatePriceForItemsWithProperty(categoryPricingName, pricingCategory);
            totalPricesCategories.add(r);
            totalPricesCategoriesRemaining.add(r);
        }
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
            if(item.getAmount()==-1){
                // paid everything
                logger.info("Paid " + totalRemaining);
            }else{
                // paid partly or too much
                logger.info("Paid " + item.getAmount());
                totalRemaining -= item.getAmount();
                logger.info(totalRemaining + " in total remaining");
            }

        }

        return true;
    }

    @Override
    public void finishTransaction(final boolean print){
        // TODO properties file
        bill.setDescription("Bill of Sale");
        bill.setScanItemsMap(basket.getScannedItems());
        bill.setTotalPrice(totalPrice);

        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < totalPricesCategories.size(); i++) {
            map.put(pricingCategories[i],totalPricesCategories.get(i));
        }
        bill.setTotalCategoryPrices(map);
        bill.setDiscount(basket.getEndDiscount());
        if(print){
            bill.print();
        }
    }
}
