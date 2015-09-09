package e20150907.fiche.logic;

import e20150907.fiche.domain.concrete.PaymentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alex on 9/7/15.
 */
public class CashRegister {
    protected static Logger logger = LogManager.getLogger(CashRegister.class.getName());
    private Sale sale;

    public CashRegister(){
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
    }



    /**
     * Sets the payment type to be displayed on bill.
     *
     * Currently only prints the type.
     *
     * @param type the payment type
     */
    public void setPaymentType(final PaymentType type){
        sale.setPaymentType(type);
    }

    /**
     * Transaction done, print bill and create a new one.
     */
    public void ding(){
        sale.finish();
    }
}
