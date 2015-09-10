package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.paymentitems.TypeCoupon;
import e20150907.fiche.logic.abs.CashRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/7/15.
 */
public class CashRegisterImpl implements CashRegister {
    protected static Logger logger = LogManager.getLogger(CashRegisterImpl.class.getName());
    private Sale sale;

    public CashRegisterImpl(){

    }

    // TODO possibly warn if previous sale hasn't finished properly yet?
    @Override
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
    @Override
    public void scan(final String code){
        sale.handleCode(code);
        logger.info("Scanned code: "+ code);
    }


    // button on register
    @Override
    public void payWithTypeCoupon(final String type, final double amount){
        sale.handlePayment(new TypeCoupon(type,amount));
    }

    // button on register
    @Override
    public void payWithCash(final double amount){
        // TODO implement
    }

    @Override
    public void payWithDigital(double amount) {
        // TODO implement
    }

    /**
     * Transaction done, print bill and create a new one.
     */
    @Override
    public void finishUpSale(){
        sale.finish();
    }
}
