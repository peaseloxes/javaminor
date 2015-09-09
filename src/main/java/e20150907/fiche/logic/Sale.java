package e20150907.fiche.logic;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.domain.concrete.Basket;
import e20150907.fiche.domain.concrete.Bill;
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

    // TODO make dynamic, properties file etc.
    private String categoryPricingName = "Type";
    private String[] pricingCategories = new String[]{"ECO","Meal"};

    private List<Double> totalPricesCategories;

    public Sale(){
        repository = new ScanItemRepository();
        bill = new Bill();
        basket = new Basket();
        totalPrice = 0;
        totalPricesCategories = new ArrayList<Double>();
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
        for (String pricingCategory : pricingCategories) {
            totalPricesCategories.add(basket.calculatePriceForItemsWithProperty(categoryPricingName,pricingCategory));
        }
    }

}
