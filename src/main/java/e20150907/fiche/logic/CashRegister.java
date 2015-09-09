package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.paymentitems.TypeCoupon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/7/15.
 */
public class CashRegister {
    protected static Logger logger = LogManager.getLogger(CashRegister.class.getName());
    private Sale sale;

    public CashRegister(){

    }

    // TODO possibly warn if previous sale hasn't finished properly yet?
    public void startNewSale(){
        sale = new Sale();
    }

    /**
     * Handles any codes scanned by a cashier.
     *
     * Delegates codes to proper handlers.
     *
     * @param code the scanned code
     */
    public void scan(final String code){
        sale.handleCode(code);
        logger.info("Scanned code: "+ code);
    }


    // button on register
    public void payWithTypeCoupon(final String type, final double amount){
        sale.handlePayment(new TypeCoupon(type,amount));
    }

    // button on register
    public void payWithCash(final double amount){

    }

    /**
     * Transaction done, print bill and create a new one.
     */
    public void ding(){
        sale.finish();
    }
}
