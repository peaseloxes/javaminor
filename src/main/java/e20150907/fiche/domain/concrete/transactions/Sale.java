package e20150907.fiche.domain.concrete.transactions;

import e20150907.fiche.domain.abs.PaymentItem;
import e20150907.fiche.domain.abs.Transaction;
import e20150907.fiche.util.PreferenceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/8/15.
 */
public class Sale extends Transaction{
    private static Logger logger = LogManager.getLogger(Sale.class.getName());

    // TODO clean up mess below

    // TODO make dynamic, properties file etc.
    private String categoryPricingName = PreferenceUtil.getCATEGORY_KEY_NAME();
    private String[] pricingCategories = PreferenceUtil.getPRICING_CATEGORIES();

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

        return payWithItem(item);
    }

    @Override
    public void closeTransaction(){
        calculate();
    }

    @Override
    public void calculate(){
        calculate2();
    }

    @Override
    public void finishTransaction(final boolean print){

        finishTransaction2(print);
    }
}
